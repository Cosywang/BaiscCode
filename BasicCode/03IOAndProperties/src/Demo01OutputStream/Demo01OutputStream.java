package Demo01OutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

/*
    public abstract class OutputStream
    java.io.OutputStream 此抽象类是表示输出字节流的所有类的超类。

    public class FileOutputStream extends OutputStream
    FileOutputStream: 文件字节输出流
        把内容中的数据写入到硬盘的文件中

    FileOutputStream(String name)
        创建一个向具有指定名称的文件中写入数据的输出文件流。
    FileOutputStream(File file)
        创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
        参数:写入数据的目的
            String name:一个文件的路径
            File file:一个文件
        作用:
            1.创建一个FileOutputStream对象
            2.根据文件/路径,创建一个空的文件
            3.会把FileOutputStream对象指向创建好的文件

    写入数据的原理
        java程序-->JVM-->OS-->OS调用写数据的方法-->把数据写入到文件中
    使用步骤:
        1.创建一个FileOutputStream对象,构造方法中传递目的地
        2.调用FileOutputStream中的write, 把数据写入到文件中
        3.释放资源
 */
public class Demo01OutputStream {
    // java.io.FileNotFoundException是IOException的子类,因此只需要捕获后者即可
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("03IOAndProperties\\a.txt");
        fos.write(97);
        fos.close();
    }
}
