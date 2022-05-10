import java.time.ZonedDateTime;

/**
 * @Description: 获取当前时间串，为网关断言时间过滤使用
 * @Author: Guo.Yang
 * @Date: 2022/05/09/17:39
 */

public class ZonedDateTimeDemo {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now (); // 默认时区
         System.out.println(zbj);
        // ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York")); // 用指定时区获取当前时间
        // System.out.println(zny);
    }
}
