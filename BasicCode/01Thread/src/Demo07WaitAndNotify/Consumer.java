package Demo07WaitAndNotify;

public class Consumer extends Thread{
    private BaoZi bz;

    public Consumer(BaoZi bz){
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true){
            synchronized (bz){
                //判断有无包子
                if (bz.flag == false){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 被唤醒之后的代码
                System.out.println("正在食用"+bz.pi+"皮"+bz.xian+"馅的包子");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 吃完之后修改包子状态
                bz.flag = false;
                // 唤醒Producer
                System.out.println("0.5秒后, "+bz.pi+"皮"+bz.xian+"馅的包子已食用完, 等待生产");
                bz.notify();
                System.out.println("============等待============");
            }
        }
    }
}
