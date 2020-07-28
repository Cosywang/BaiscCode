package Demo04InnerClassThread;

import Demo03Runnable.RunnableImpl;

/*
    匿名内部类的作用：简化代码

    格式：
        new 父类/接口(){
            覆盖super中的方法
        }
 */
public class demo01InnerClassThread {
    public static void main(String[] args) {
        // 第一种开启线程的方法
        new Thread(){
            // 重写run()，设置线程任务
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();

        // 第二种 线程的接口Runnable
        Runnable r = new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        new Thread(r).start();

        // 第三种
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }
        ).start();
    }
}
