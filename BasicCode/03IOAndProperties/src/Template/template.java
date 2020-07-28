package Template;

import java.util.Scanner;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class template {
    public static void main(String[] args) {
        // 读取输入
        Scanner in = new Scanner(System.in);
        String tmp = in.nextLine();
        // 按空格划分
        String[] tmpArr = tmp.split("\\s+");

        // int[]转List
        int[] intArr = {1,2,3,4,5};
        List<Integer> lst = Arrays.stream(intArr).boxed().collect(Collectors.toList());
    }

}
