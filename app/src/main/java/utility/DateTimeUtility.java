package utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtility {

    public static String formatDate(Date date){

        return new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH).format(date);
    }

    public static String formatTime(Date time){

        return new SimpleDateFormat("HH:mm aa",Locale.ENGLISH).format(time);
    }

    public static double timeDiff(Date startTime,Date endTime){

        long diff = endTime.getTime() - startTime.getTime();

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli*60;
        long hoursInMilli = minutesInMilli*60;

        long hour = diff/hoursInMilli;
        diff%=hoursInMilli;

        double minutes = (double) (diff/minutesInMilli)/60;

        return hour+minutes;
    }

}
