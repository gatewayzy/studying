package javaModule.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dell on 2017/6/19.
 */
public class TimeUtils {
    public static final String timeFormatString = "yyyy/MM/dd HH:mm:ss";

    public static String time(){
        return new SimpleDateFormat(timeFormatString).format(new Date());
    }


}
