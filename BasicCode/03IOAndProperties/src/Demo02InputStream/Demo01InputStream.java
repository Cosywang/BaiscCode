package Demo02InputStream;

import java.io.FileInputStream;
import java.io.IOException;

/*
    abstract class InputStream
        此抽象类是表示字节输入流的所有类的超类。

    定义了所有子类共性的方法:
        abstract  int read() 从输入流中读取数据的下一个字节。
        int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
        void close() 关闭此输入流并释放与该流关联的所有系统资源。

    FileInputStream extends InputStream
    作用: 把硬盘中的数据,读取到内存中使用

    构造方法:
        FileInputStream(String name)
        FileInputStream(File file)
        参数:读取文件的数据源
        构造方法的作用:
            1.会创建一个FileInputStream对象
            2.会把FileInputStream对象指定构造方法中要读取的文件

    读取数据的原理(硬盘-->内存)
        java程序-->JVM-->OS-->OS读取数据的方法-->读取文件

    步骤(重点):
        1.创建FileInputStream对象
        2.用read方法
        3.释放资源
 */
public class Demo01InputStream {
    public static void main(String[] args) throws IOException {
        // 1
        FileInputStream fis = new FileInputStream("03IOAndProperties\\a.txt");
        // 2
        // int read()读取文件中的一个字节并返回,读取到文件的末尾返回-1
        /*
        int len = fis.read();   // 97
        System.out.println(len);

        len = fis.read();       // 98
        System.out.println(len);

        len = fis.read();       // 99
        System.out.println(len);

        len = fis.read();       // -1
        System.out.println(len);
        */

        /*
        布尔表达式
            1. fis.read()
            2. len = fis.read()
            3. len != -1
        */

        int len;
        while((len = fis.read()) != -1){ // abc
            System.out.println((char)len);
        }

        /*while(fis.read() != -1){ // 98 -1
            System.out.println(fis.read());
        }*/

        // 3
        fis.close();

    }
}
