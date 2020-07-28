package Demo02GetSetName;

public class Demo01Thread {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        // 第一种设置线程的名称，第二种见MyThread
        mt.setName("小强");
        mt.start();

        // sleep方法需要捕获异常，这里使用try...catch捕获
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new MyThread("旺财").start();
        /*
            注意这里小强和旺财出现的顺序仍然不一定
         */
    }
}
