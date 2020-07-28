package Demo05ThreadSafe;

public class RunnableImpl implements Runnable {
    private int ticket = 20;

    @Override
    public void run() {
        while(ticket>0){
            // 提高问题出现的概率,睡眠
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票");
            ticket--;
        }
    }
}
