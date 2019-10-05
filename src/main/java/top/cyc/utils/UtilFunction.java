package top.cyc.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class UtilFunction {

    public static String TimeFormat(Timestamp timestamp){
        Date date = new Date(timestamp.getTime());
        Date now = new Date(System.currentTimeMillis());
        int dateDiffer = differentDays(now,date);
        if(dateDiffer==0){
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            return "今日 " + format.format(date);
        }
        if(dateDiffer==-1){
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            return "昨日 " + format.format(date);
        }
        if(dateDiffer == 1){
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            return "明日 " + format.format(date);

        }
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日  HH:mm");
        return format.format(date);
        // (now-time)/(……)的结果和上面的结果不一样噢
//        if(day == -1){// 明天
//            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
//            return "明日 " + format.format(date);
//        }
//        if (day == 0) {  //今天
//            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
//            return "今日 " + format.format(date);
//        } else if (day == 1) {     //昨天
//            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
//            return "昨日 " + format.format(date);
//        } else {    //可依次类推
//            SimpleDateFormat format = new SimpleDateFormat("MM月dd日  HH:mm");
//            return format.format(date);
//        }
    }
    private static int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }
    public static Timestamp getCurrentZeroTime(){
        long current = System.currentTimeMillis();
        long zero = current/(1000*3600*24)*(1000*3600*24) - TimeZone.getDefault().getRawOffset();
        return  new Timestamp(zero);
    }
}
