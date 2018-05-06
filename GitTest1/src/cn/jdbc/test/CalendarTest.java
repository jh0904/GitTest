package cn.jdbc.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/*
* 利用Calendar计算柿饼的保质期30天
* */
public class CalendarTest {
    public static void main(String[] args) throws ParseException {
        String s="2017-12-10";
        SimpleDateFormat sf=new SimpleDateFormat ("yyyy-MM-dd");
        Date parse = sf.parse (s);
        System.out.println (sf.format (parse));
        Calendar c = Calendar.getInstance();
        c.setTime (parse);
        c.add (Calendar.DATE,30);
        System.out.println (sf.format (c.getTime ()));
    }
}
