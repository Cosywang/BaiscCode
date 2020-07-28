package Demo01Lambda;
/*
    Lambda表达式的标准格式:
        1.一些参数
        2.一个箭头
        3.一段代码
    格式:
        (参数列表) -> {一些重写方法的代码};
    解释:
        (): 接口中抽象方法的参数列表, 没有参数就空着, 有参数就写参数
                参数类型可以省略,参数唯一时,'()'也可以省略
        ->: 参数传递给方法题
        {}: 重写接口的抽象方法的方法体
                方法题只有一行时,'return',';'和'{}'均可以省略
    注意:
        1.使用Lambda必须有接口,且要求接口中有且仅有一个抽象方法
        2.使用Lambda必须具有上下文推断
            也就是方法的参数或局部变量类型必须为Lambda对应的接口类型,才能使用Lambda作为该接口的实例
 */
public class demo01Lambda {
    public static void main(String[] args) {
        // 使用匿名内部类实现多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"创建了");
            }
        }
        ).start();

        // 使用Lambda实现多线程
        new Thread(()-> System.out.println(Thread.currentThread().getName()+"创建了")
        ).start();
    }
}
