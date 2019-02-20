package interfaceTest;

/**
 * 接口可以有抽象方法，也可以有静态的普通方法（含方法体）
 */
public interface Test {
    static final String name = "11";
    //void sayHello();

    static void sayHello(String name) {

    }

    default void hello() {
        System.out.println("hello");
    }

    void sayHello(String name, Integer age);

    static void main(String[] args) throws Exception {
        //如果放开sayHeelo()方法，编译无法通过,原因在于JVM不能推断出 ->后面的为哪个方法的内容
        Test test = (x,y) -> System.out.println("hello"+x+",我今年"+y);
        test.sayHello("张三",20);

        System.out.println(Test.name);


    }
}
