package lambda;

import java.util.Arrays;
import java.util.List;

public class Demo6 {

    private static double[] imperativeInitilize(int size) {
        double[] array = new double[size];
        for(int i = 0; i<size; i++) {
            array[i] = i;
        }

        return array;
    }

    /**
     * Arrays.parallelSetAll 实行并行化操作
     * @param size
     * @return
     */
    private static double[] parallelInitialize(int size) {
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> i);
        return values;
    }

    //将列表中的数字相乘，最后乘5
    public static int multiplyThrough(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.stream()
                .reduce(5, (acc, x) -> x * acc);
    }

    public static void main(String[] args) throws Exception {
//        double[] values = parallelInitialize(1000);
//        System.out.println(Arrays.asList(values));

        int value = multiplyThrough(Demo5.getArrayList(3));
        System.out.println(value);

    }
}
