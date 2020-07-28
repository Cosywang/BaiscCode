package Demo08ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    java.util.concurrent.Executors
    static ExecutorService newFixedThreadPool(int nThreads)
          创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程。
    参数:
        int 线程池中的线程数量
    返回值:
        ExecutorService接口,返回的是ExecutorService接口的实现类对象,我们可以使用接口接收(面向接口编程)

    java.util.concurrent.ExecutorService:线程池接口
        用来从线程池中获取线程,调用start方法,执行线程任务
            submit(Runnable task) 提交一个 Runnable 任务用于执行，并返回一个表示该任务的 Future。
        关闭/销毁线程池:
            void shutdown() 启动一次顺序关闭，执行以前提交的任务，但不接受新任务。

    线程池使用步骤:
        1. newFixedThreadPool
        2. 创建一个类,实现Runnable接口,重写run方法,设置线程任务
        3. 调用ExecutorService中的submit,传递线程任务(实现类),开启线程并执行run
        4. 调用ExecutorService中的shutDown销毁线程池(不建议执行)
 */
public class Demo01ThreadPool {
    public static void main(String[] args) {
        // 1
        ExecutorService es = Executors.newFixedThreadPool(2);
        // 3
        // 线程池会一直开启,线程使用完了后,会自动把线程归还给线程池
        es.submit(new RunnableImpl()); //pool-1-thread-2创建了一个新的线程执行
        es.submit(new RunnableImpl()); //pool-1-thread-1创建了一个新的线程执行
        es.submit(new RunnableImpl()); //pool-1-thread-1创建了一个新的线程执行
    }
}
