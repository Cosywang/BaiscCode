package Demo06Synchronized;
/*
    卖票案例出现了线程安全问题
    卖出了不存在的票和重复的票

    解决办法1: 使用同步代码块
    格式:
        synchronized(锁对象){
            可能会出现线程安全问题的代码(访问了共享数据的代码)
        }

    注意:
        1.通过代码块中的锁对象,可以使用任意的对象
        2.但是必须保证多个线程使用的锁对象是同一个
        3.锁对象作用:
                把同步代码块锁住,只让一个线程在其中执行
    缺点:
        程序频繁地判断锁,获取锁,释放锁,效率比较低下
 */
public class RunnableImpl implements Runnable {
    private int ticket = 20;

    // 创建一个锁对象
    Object obj1 = new Object();
    Object obj2 = new Object();

    @Override
    public void run() {
        while(ticket > 0){
            // 同步代码块
            synchronized (obj1){
                if(ticket>0)
                System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票");
                ticket--;
            }
            synchronized (obj2){
                System.out.println("test");
            }
        }
    }
}
