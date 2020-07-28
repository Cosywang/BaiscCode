package Demo01Thread;

public class demo01Thread {
    /*
        JVM执行main方法，找OS开辟一条main方法通向CPU的路径
        这个路径叫main线程，即主线程
        CPU通过这个线程，这个路径可以执行main方法
     */
    public static void main(String[] args) {
    /*
        new了一个Thread之后，开辟一条通向CPU的新路径
        用来执行run方法
        ----------------
        对于CPU而言，有了两条执行的路径，就有了选择的权力
        CPU喜欢谁就执行哪条路径，我们控制不了CPU

        对于两条线程而言，一起抢夺CPU的执行权
        谁抢到了谁执行对应的代码
     */
        MyThread mt = new MyThread();
        mt.start();

        //主线程会继续执行主方法中的代码
        for (int i = 0; i < 5; i++) {
            System.out.println("main" + i);
        }
    }
}
