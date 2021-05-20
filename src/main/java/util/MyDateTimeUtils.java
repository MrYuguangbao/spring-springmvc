package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author admin
 * @date 2019/5/16 0:08
 */
public class MyDateTimeUtils {

    public static String format(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String dateTime = formatter.format(time);
        return dateTime;
    }

    public static void main(String[] args) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        try {
            map.put(null, "value");
        } catch (Exception e) {
            System.out.println(map.getClass().getName() + "的key不能为null");
            e.printStackTrace();
        }

        try {
            map.put("key", null);
        } catch (Exception e) {
            System.out.println(map.getClass().getName() + "的value不能为null");
            e.printStackTrace();
        }

    }
}
