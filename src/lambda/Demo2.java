package lambda;

import javax.swing.text.DateFormatter;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * 函数接口：只有一个抽象方法的接口 目的为让jvm能根据上下文确定 ->后面的代码块属于哪个方法
 * 重要函数接口：Predicate，BinaryOperator，Consumer，Supplier，Function，UnaryOperator
 */
public class Demo2 {
    public static void main(String[] args) throws Exception {
        Predicate<Integer> predicate = x -> x > 5;
        System.out.println(predicate.test(10));

        BinaryOperator<Integer> add = (x, y) -> x + y;
        System.out.println(add.apply(1,1));

    }

    public void DateFormatterTest() {
        DateFormatter dateFormatter = new DateFormatter();
    }
}
