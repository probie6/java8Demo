package lambda;

import entity.User;
import org.junit.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * flatmap 将多个stream流合并为一个stream。对比 下面两种 获取User对象朋友字段 名字大于2的集合的方法。使用flatmap更加简洁
 */
public class Demo4 {

    public static void main(String[] args) throws Exception {
        List<String> list = getListUser().stream().
                flatMap(x -> x.getFeriends().stream()).
                filter(x -> x.length() == 2).
                collect(Collectors.toList());


        List<String> list2 = new ArrayList<>();
        getListUser().
                forEach(friend -> {
                    friend.getFeriends().stream().filter(name -> name.length() == 2).map(name -> name).forEach(list2::add);
                });
        System.out.println(Collections.singletonList(list));
        System.out.println(Collections.singletonList(list2));

        long count = getLowerCounts("AbcHsfsdfsdfd");
        System.out.println(count);


    }

    private static List<User> getListUser() {
        List<User> list = new ArrayList<>();
        User user1 = new User("one", Arrays.asList("1","22","333"));
        User user2 = new User("two", Arrays.asList("4","55","666"));
        list.add(user1);
        list.add(user2);
        return list;

    }

    //计算一个字符串中小写字母的个数
    private static long getLowerCounts(String str) {
        IntStream chars = str.chars();
        long count = chars.filter(x -> isLower((char) x)).count();


        return count;
    }
    private static boolean isLower(char c){
        return c >= 97 && c <= 122;
    }
}
