package lambda;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class demo1 {
    public static void main(String[] args) throws Exception {
        String name = "张三";
        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(name+"1111");
            }
        });
        one.start();

        Thread two = new Thread(() -> {
            for(int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        });
        two.start();

    }
}
