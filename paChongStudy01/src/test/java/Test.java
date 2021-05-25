import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test
{
    @org.junit.Test
    public  void p(){
        // 按指定模式在字符串查找
        String line = "https://pic.yupoo.com/jdvip/BQSJzdk5/custom.jpg";
        String pattern = "(?<=https://)(.*)(?=.jpg)";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        while (m.find()) {
            String subString = line.substring(m.start(), m.end());
        }
        //        if (m.find( )) {
//            System.out.println("Found value: " + m.group(0) );
//            System.out.println("Found value: " + m.group(1) );
//            System.out.println("Found value: " + m.group(2) );
//            System.out.println("Found value: " + m.group(3) );
//        } else {
//            System.out.println("NO MATCH");
//        }
    }
}
