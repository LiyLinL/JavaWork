package com.run.liy;

import java.util.Calendar;
import java.util.Date;

public class mainTest {

    public static void main(String[] args) {
//      String[] sfcList = {"11111", "22222", "33333", "44444", "55555"};
//
//      Map<String, String> map = new HashMap<>();
//      map.put("11111", "A");
//      map.put("22222", "B");
//      map.put("33333", "A");
//      map.put("44444", "C");
//      map.put("55555", "A");
//
//
//      Map<String, List<String>> mapObj = new HashMap<>();
//
//      for ( String s : sfcList ) {
//         if (mapObj.get(map.get(s)) == null ) {
//            List<String> lists = new ArrayList<>();
//            lists.add(s);
//            mapObj.put(map.get(s), lists);
//         }
//         else {
//            mapObj.get(map.get(s)).add(s);
//         }
//      }
//
//      Iterator<Map.Entry<String, List<String>>> m = mapObj.entrySet().iterator();
//      while (m.hasNext()) {
//            Map.Entry<String, List<String>> entry = m.next();
//            System.out.println(entry.getKey() + "==" + entry.getValue());
//      }
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int w = cal.get(Calendar.WEEK_OF_YEAR);
        System.out.println(w);
        if (w % 2 != 0) {
            Date one = getThisWeekMonday(cal.getTime());
            cal.setTime(one);
            cal.add(Calendar.DATE, -7);
            System.out.println(cal.getTime());
        }
    }

    public static Date getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }
}