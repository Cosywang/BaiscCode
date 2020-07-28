package Demo03ParamReturn;

import java.util.Arrays;
import java.util.Comparator;

public class Demo01ParamReturn {
    public static void main(String[] args) {
        //使用数组存储多个Person对象
        Person[] arr = {
                new Person("A", 38),
                new Person("B", 18),
                new Person("C", 19)
        };
        //对数组中的Person对象使用Arrays的sort方法按年龄升序排序
        /*
        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        */

        //使用Lambda
        Arrays.sort(arr, (Person o1, Person o2)->{return o1.getAge()-o2.getAge();});

        //遍历数组
        for (Person person : arr) {
            System.out.println(person);
        }
    }


}
