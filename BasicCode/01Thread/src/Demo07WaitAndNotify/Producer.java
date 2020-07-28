package Demo07WaitAndNotify;
/*
    老板和包子线程关系-->通信(互斥)
    使用同步锁
 */
public class Producer extends Thread{
    private BaoZi bz;

    public Producer(BaoZi bz){
        this.bz = bz;
    }

    @Override
    public void run() {
        int count = 0; // 为生产两种包子做准备
        while (true) {
            synchronized (bz){
                // 判断有无包子
                if (bz.flag == true){
                    // 若有, 不用继续做包子
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 被唤醒之后执行, 生产包子
                if (count%2 == 0){
                    bz.pi = "薄";
                    bz.xian = "三鲜";
                }else{
                    bz.pi = "冰";
                    bz.xian = "牛肉";
                }
                count++;
                System.out.println("包子铺正在生产"+bz.pi+"皮"+bz.xian+"馅的包子");
                // 生产包子需要3秒
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 修改包子的状态
                bz.flag = true;
                System.out.println(bz.pi+"皮"+bz.xian+"馅的包子生产完成!");
                bz.notify();
            }
        }

    }
}
