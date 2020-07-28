package Demo05ThreadSafe;
/*
    模拟卖票案例
    创建3个线程,同时开启,对共享的票进行出售
 */
public class demo01Ticket {
    public static void main(String[] args) {
        //创建Runnable接口的实现对象
        RunnableImpl run = new RunnableImpl();
        //创建Thread类对象,构造方法中传递Runnable接口的实现类对象
        Thread t0 = new Thread(run);
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        //调用start方法开启多线程
        t0.start();
        t1.start();
        t2.start();
    }
}

/*
Thread-1正在卖第20张票
Thread-2正在卖第20张票
Thread-0正在卖第20张票
Thread-0正在卖第17张票
Thread-2正在卖第17张票
Thread-1正在卖第17张票
Thread-2正在卖第14张票
Thread-1正在卖第14张票
Thread-0正在卖第14张票
Thread-2正在卖第11张票
Thread-1正在卖第11张票
Thread-0正在卖第11张票
Thread-0正在卖第8张票
Thread-1正在卖第8张票
Thread-2正在卖第8张票
Thread-2正在卖第5张票
Thread-1正在卖第5张票
Thread-0正在卖第5张票
Thread-0正在卖第2张票
Thread-1正在卖第2张票
Thread-2正在卖第2张票
Thread-0正在卖第-1张票

注意:
    同时卖一张票的原因是, 三个线程同时执行到了"输出",而此时还没执行到ticket--
    最后出现-1是因为,之前Thread-0,1,2同时卖出了第2张票,且执行了ticket--,Tread-0执行完ticket--后,
        剩下两个线程还没执行到ticket--,还有余票,因此对于Thread-0来说,程序继续执行,可是执行到"输出"时,
        那两个线程已经将ticket减到-1了,这是Tread-0由于还在循环中,因此继续执行输出和ticket--
        程序不再继续执行时,ticket = -2
 */
