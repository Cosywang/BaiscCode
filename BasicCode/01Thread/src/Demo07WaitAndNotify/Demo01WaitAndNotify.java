package Demo07WaitAndNotify;
/*
    等待唤醒案例: 线程之间的通信
        创建一个顾客线程, 告知老板包子的种类和数量, 接着调用wait(), 进入到WAITING状态(无限等待)
        创建一个老板线程, 花了5秒做包子, 之后调用notify(), 唤醒顾客

    注意:
        顾客和老板线程必须使用同步代码块包裹起来,保证等待和唤醒只能有一个在执行
        同步使用的锁对象必须保证唯一
        只有锁对象才能调用wait()和notify()

    Object类中的方法
        void wait()
        void notify()
 */
public class Demo01WaitAndNotify {
    public static void main(String[] args) {
        // 创建锁对象,保证唯一
        Object obj = new Object();
        // 创建一个顾客线程
        new Thread(){
            @Override
            public void run() {
                while (true){ // 一直要买包子
                    //同步
                    synchronized (obj){
                        System.out.println("告知老板要什么");
                        //调用wait
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // 唤醒之后执行的代码
                        System.out.println("包子做好了,开吃!");
                        System.out.println("============离开===========");
                    }
                }
            }
        }.start();

        // 创建一个老板线程
        new Thread(){
            @Override
            public void run() {
                while (true){ // 你买我就做
                    // 花5秒做包子
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // 同步
                    synchronized (obj){
                        //做好包子调用notify,唤醒顾客
                        System.out.println("老板5秒之后包子做好了");
                        obj.notify();
                    }
                }
            }
        }.start();
    }
}
