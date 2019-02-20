package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * stream()串行执行
 * parallelStream()并行执行
 * 本demo测试不同数据量 串行执行和并行执行的效率问题
 */
public class Demo5 {
    private static final Integer initCount = 10000;

    public static void main(String[] args) throws Exception {
        //ArrayList(数据结构性能测试
        long time = System.currentTimeMillis();
        List<Integer> list = getArrayList(initCount);

        long startTime = System.currentTimeMillis();
        System.out.println("获取ArrayList数据源耗时:"+(startTime-time));
        int count = list.parallelStream().mapToInt(i -> i).sum();
        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList并行耗时:"+(endTime-startTime));

        startTime = System.currentTimeMillis();
        count = list.stream().mapToInt(i -> i).sum();
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList串行耗时:"+(endTime-startTime));

        //LinkedList数据结构性能测试
        time = System.currentTimeMillis();
        list = getLinkedList(initCount);

        startTime = System.currentTimeMillis();
        System.out.println("获取LinkedList数据源耗时:"+(startTime-time));
        count = list.parallelStream().mapToInt(i -> i).sum();
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList并行耗时:"+(endTime-startTime));

        startTime = System.currentTimeMillis();
        count = list.stream().mapToInt(i -> i).sum();
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList串行耗时:"+(endTime-startTime));


    }

     static List<Integer> getArrayList(int size) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<size ;i++ ) {
            list.add(i+1);
        }
        return list;
    }

     static List<Integer> getLinkedList(int size) {
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i<size ;i++ ) {
            list.add(i+1);
        }
        return list;
    }

    @Test
    public void LinkedListTest() {
        List<Integer> list = new LinkedList<>();
        list.addAll(Demo5.getArrayList(initCount));

        System.out.println(list.get(10));
    }

    @Test
    public  void test() {
        double i = 0;
        double n = 0;
        int number;
        Random random = new Random();
        for(int j = 0; j<100000000; j++) {
            number = (int)(random.nextInt(2));
            if(number == 0) {
                i++;
            }
            if(number == 1) {
                n++;
            }
        }
        System.out.println("0的次数:"+i);
        System.out.println("1的次数:"+n);
        System.out.println(i/n);
    }
}
