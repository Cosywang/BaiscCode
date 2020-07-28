package Demo03Reader;

import java.io.FileReader;
import java.io.IOException;
/*
    字符流每次读取一个字符,不管是中文还是英文
    字节流每次读取一个字节,可能会有中文乱码的问题
 */
public class Demo01Reader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("03IOAndProperties\\c.txt");

        /*int len;
        while ((len = fr.read()) != -1){
            System.out.print((char)len);
        }*/

        char[] cs = new char[1024];
        int len;
        while ((len = fr.read(cs)) != -1){
            System.out.println(len);
            System.out.println(new String(cs, 0, len));
        }

        fr.close();
    }
}
