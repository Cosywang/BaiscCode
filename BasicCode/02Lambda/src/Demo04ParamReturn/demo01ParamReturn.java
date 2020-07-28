package Demo04ParamReturn;

public class demo01ParamReturn {
    public static void main(String[] args) {
        invokeCalc(10, 20, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a+b;
            }
        });

        //Lambda
        invokeCalc(10,20,(a, b)-> a+b );
    }

    //定义一个方法,参数传递两个int类型的参数
    //参数传递Calculator接口
    public static void invokeCalc(int a, int b, Calculator c){
        int sum = c.calc(a, b);
        System.out.println(sum);
    }
}
