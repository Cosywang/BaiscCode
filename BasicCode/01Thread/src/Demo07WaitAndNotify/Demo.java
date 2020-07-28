package Demo07WaitAndNotify;

public class Demo {
    public static void main(String[] args) {
        BaoZi bz = new BaoZi();
        new Producer(bz).start();
        new Consumer(bz).start();
    }
}
