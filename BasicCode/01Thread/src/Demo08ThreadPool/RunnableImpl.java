package Demo08ThreadPool;
// 2
public class RunnableImpl implements Runnable{
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "创建了一个新的线程执行");
    }
}