import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

    public static void main( String[] args ){

        // 按指定模式在字符串查找
        String line = "ori $1 OK?";
        String pattern = "ori \\$(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
        } else {
            System.out.println("NO MATCH");
        }
    }
}
