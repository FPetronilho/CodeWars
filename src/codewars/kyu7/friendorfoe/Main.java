package codewars.kyu7.friendorfoe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println(friend(Arrays.asList("Ryan", "Kieran", "Jason", "Yous")));
    }

    public static List<String> friend(List<String> x) {
        return x.stream()
                .filter(n -> n.length() == 4)
                .collect(Collectors.toList());
    }
}
