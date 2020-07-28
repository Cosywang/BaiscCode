package Demo03Runnable;
/*
    使用Runnable接口创建多线程步骤：
        1.创建一个Runnable接口
        2.在实现类中重写Runnable接口的run方法，设置线程任务
        3.创建Runnable接口的实现类对象
        4.创建Thread类对象，构造方法中传递Runnable接口的实现类对象
        5.调用Thread类中的start方法，开启新的线程执行run方法

    使用Runnable有什么好处呢？
        1.避免了单继承的局限性
            MyThread必须继承Thread，这样无法继承其他类，但是可以实现多个接口
        2.增强了程序的扩展性，降低了程序的耦合性（解耦）
            设置线程任务和开启新线程进行了分离
            实现类中，重写了run()，用来设置线程任务
            创建Thread类对象，调用start()，用来开启新线程
 */
public class demo01Thread {

    public static void main(String[] args) {
        RunnableImpl rable = new RunnableImpl();
        Thread t = new Thread(rable);
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
