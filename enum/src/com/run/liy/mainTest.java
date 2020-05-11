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
//        System.out.println(w);
        if (w % 2 != 0) {
            Date one = getThisWeekMonday(cal.getTime());
            cal.setTime(one);
            cal.add(Calendar.DATE, -7);
//            System.out.println(cal.getTime());
        }
        Test();
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

    public static void Test() {
        String a = "AXA53450001ABCDA";
        char[] c = a.toCharArray();
        int k = 0;
        for (int i = 1; c.length > i; i += 2) {
            k += rt(c[i]);
        }
        System.out.println(k*3);
        int t = 0;
        for (int i = 0; c.length > i; i += 2) {
            t += rt(c[i]);
        }
        System.out.println(t);
    }

    public static int rt(char a) {
        switch (a) {
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            case 'G':
                return 16;
            case 'H':
                return 17;
            case 'J':
                return 18;
            case 'K':
                return 19;
            case 'L':
                return 20;
            case 'M':
                return 21;
            case 'N':
                return 22;
            case 'P':
                return 23;
            case 'Q':
                return 24;
            case 'R':
                return 25;
            case 'S':
                return 26;
            case 'T':
                return 27;
            case 'U':
                return 28;
            case 'V':
                return 29;
            case 'W':
                return 30;
            case 'X':
                return 31;
            case 'Y':
                return 32;
            case 'Z':
                return 33;
            default:
                return Integer.parseInt(String.valueOf(a));
        }
    }
}