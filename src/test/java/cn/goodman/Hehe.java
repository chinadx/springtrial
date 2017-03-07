package cn.goodman;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Shaun on 2017/2/14.
 */
public class Hehe {
    public static void main(String[] args) {
        final String ff;
        ff = "asbd";
    }
    public static void main22 (String[] args) {
        String xx = "7ED56A3A91A443EA95DEF8FF55C8FE93";
        String fmt = MessageFormat.format("{0}, a {1} destroyed the {2} town, {3} people died.",
                new Date(), "blizzard storm", "South Park", 312);
        System.out.println(fmt);
        StringBuffer bf = new StringBuffer(xx);
        System.out.println(bf.toString());
        bf.reverse();
        System.out.println(bf.toString());

        char[] ca = xx.toCharArray();
        String nn = "";
        for(int i = ca.length; i>0; i--) {
            nn += ca[i-1];
        }
        System.out.println(nn);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
        try {
            Date begin = sdf.parse("2017/5/12");
            Date end = sdf.parse("2017/5/20");
            long duration = (end.getTime() - begin.getTime())/(24 * 60 * 60 * 1000);
            System.out.println(duration);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
