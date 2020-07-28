package Demo01OutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Demo02OutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("03IOAndProperties\\b.txt");

        // 在文件中显示100,需要写3个字节
        fos.write(49);
        fos.write(48);
        fos.write(48);

        // 如果写的第一个字节是正数(0-127),那么显示的时候会查询ASCII表
        // 如果写的第一个字节是负数,那第一个字节会和第二个字节,两个字节组成一个中文显示,查询系统默认表(GBK)

        byte[] bytes = {65,66,67,68,69}; // ABCDE
//        byte[] bytes = {-65,-66,-67,68,69}; // 烤紻E
        fos.write(bytes);

        // void write(byte[] b, int off, int len)
        //     将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。
        fos.write(bytes,1, 2); // BC

        //
        byte[] bytes2 = "你好".getBytes();
        System.out.println(Arrays.toString(bytes2));
        fos.write(bytes2);

        fos.close();
    }


}
