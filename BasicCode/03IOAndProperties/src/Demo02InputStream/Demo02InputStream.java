package Demo02InputStream;

import java.io.FileInputStream;
import java.io.IOException;

/*
    字节输入流一次读取多个字节的方法:
        int read(byte[] b) 从输入流中读取一定数量的字节,并将其存储在缓冲区数组b中
    明确两件事情:
        1.方法的参数byte[]的作用:
            起到缓冲作用,存储每次读取到的多个字节
            数组的长度一般定义位1024(1kb)或者1024的整数倍
        2.方法的返回值int是什么?
            每次读取的有效字节个数
 */
public class Demo02InputStream {
    public static void main(String[] args) throws IOException{
        FileInputStream fis = new FileInputStream("03IOAndProperties\\b.txt");

        // bytes相当于一个容器,存储每次读取的数据
        byte[] bytes = new byte[2];
        // len是读取的有效字节数
        int len = fis.read(bytes);
        System.out.println(len);//2
        System.out.println(new String(bytes));//AB

        len = fis.read(bytes);
        System.out.println(len);//2
        System.out.println(new String(bytes));//CD

        // 这里读取的时候只成功读取到了E, 因此E把C替换掉了
        len = fis.read(bytes);
        System.out.println(len);//1
        System.out.println(new String(bytes));//ED

        // 这里没有读取成功, 但是bytes中还存有ED
        len = fis.read(bytes);
        System.out.println(len);//-1
        System.out.println(new String(bytes));//ED

        fis.close();
    }
}
