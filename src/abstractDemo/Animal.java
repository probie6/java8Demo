package abstractDemo;

public interface  Animal {
    //private String name;

    //public void say();

    public void say(String name);

    public static void hello() {
        System.out.println("hello");
    }

    public static void main(String[] args) throws Exception {
//        Animal animal = new Animal() {
//            @Override
//            public void say() {
//                System.out.println("say");
//            }
//        };

        Animal animal = (x) -> System.out.println("say");

    }

}
