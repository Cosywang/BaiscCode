package Demo02GetSetName;

public class MyThread extends Thread {
    public MyThread(){}

    // 使用带参构造方法设置name
    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

    }
}
