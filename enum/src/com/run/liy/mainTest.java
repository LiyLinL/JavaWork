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
        if (w % 2 != 0) {
            Date one = getThisWeekMonday(cal.getTime());
            cal.setTime(one);
            cal.add(Calendar.DATE, -7);
        }
        String serNo = serNoProcess(1000);
    }

    public static Date getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    public static void process(String s) {
        char[] c = s.toCharArray();
        int k = 0;
        for (int i = 1; c.length > i; i += 2) {
            k += textToNo(c[i]);
        }
        int t = 0;
        for (int i = 0; c.length > i; i += 2) {
            t += textToNo(c[i]);
        }
        int a = k * 3;
        int d = (a + t) % 34;
        int f = 34 - d;
    }

    public static int textToNo(char c) {
        int i = (int) c;
        if (i <= 57) {
            return Integer.parseInt(String.valueOf(c));
        }
        if (i < 72) {
            i -= 55;
            return i;
        }
        if (i >= 73 && i < 79) { // 跳過 I,所以多減1
            i -= 56;
            return i;
        }
        if (i >= 79) { // 跳過 O,所以多減2
            i -= 57;
            return i;
        }
        return i;
    }

    public static String noToText(int i) {
        if (i < 9) {
            return String.valueOf(i);
        }
        if (i > 9) {
            i += 55;
        }
        if (i > 72 && i < 79) { // 跳過 I
            i += 1;
        }
        if (i >= 79) { // 跳過 O
            i += 2;
        }
        char c = (char) i;
        return String.valueOf(c);
    }

    private static String serNoProcess(int seq) {
        int uni = seq % 34; // 個位
        int ten = 0; // 十位
        int hun = 0; // 百位
        int thu = 0; // 千位

        int exc1 = seq / 34;
        if (exc1 > 0) {
            ten = exc1 % 34;

            int exc2 = exc1 / 34;
            if (exc2 > 0) {
                hun = exc2 % 34;

                int exc3 = exc2 / 34;
                if (exc3 > 0) {
                    thu = exc3 % 34;
                }
            }
        }
        return String.format("%s%s%s%s", noToText(thu), noToText(hun), noToText(ten), noToText(uni));
    }
}