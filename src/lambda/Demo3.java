package lambda;

import entity.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Demo3 {

    private static List<Integer> getList() {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<1000 ;i++ ) {
            list.add(i);
        }

        return list;
    }

    public static void main(String[] args) throws Exception {

        //count(),返回集合数
        List<Integer> list = getList();
        long count  = list.stream().filter(x -> {
            System.out.println(x);
            return x % 5 == 0;
        }).count();

        //collect(toList())返回集合
        list = list.stream().filter(x -> {
            System.out.println(x);
            return x % 5 == 0;
        }).collect(toList());

        //map操作，将一组小写字符串转换为大写
        List<String> collected = Stream.of("a","b","hello").map(String::toUpperCase).collect(toList());
        System.out.println(Collections.singletonList(collected));


        //flatMap操作，将两个集合合并为一个
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(Collection::stream)
                .collect(toList());

        //max、min操作
        List<Integer> lists = asList(10,20,5,23,100,3);
        Integer max = lists.stream().max(Comparator.comparing(x -> x)).get();
        System.out.println("最大值："+max);

        //reduce求和操作 q其中0代表初始值 acc为累加器，保存着当前累加结果，element为传入的数值，最后返回的为acc
        int sum = Stream.of(1, 2, 3)
                .reduce(0, (acc, element) -> acc + element);
        System.out.println("sum:"+sum);

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("张三"));
        personList.stream().forEach(person -> person.setName("王五"));
        System.out.println(111);



    }
}
