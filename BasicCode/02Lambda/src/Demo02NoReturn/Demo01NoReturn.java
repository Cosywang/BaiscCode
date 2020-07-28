package Demo02NoReturn;

public class Demo01NoReturn {
    public static void main(String[] args) {
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("开饭了!");
            }
        });

        // Lambda
        invokeCook(() -> {System.out.println("开饭了!");});
    }

    public static void invokeCook(Cook cook){
        cook.makeFood();
    }
}
