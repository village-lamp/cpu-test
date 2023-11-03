import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        String regex = "@\\w{8}: ((\\$(( [1-9])|(\\d{2})))|(\\*\\w{8})) <= \\w{8}";
        String test = "@00003000: *3424344e <= 4324fe33";
        System.out.println(test.matches(regex));
    }
}
