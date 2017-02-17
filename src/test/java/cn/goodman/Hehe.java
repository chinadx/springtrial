package cn.goodman;

import java.text.MessageFormat;
import java.util.Date;

/**
 * Created by Shaun on 2017/2/14.
 */
public class Hehe {
    public static void main (String[] args) {
        String xx = "7ED56A3A91A443EA95DEF8FF55C8FE93";
        String fmt = MessageFormat.format("{0}, a {1} destroyed the {2} town, {3} people died.",
                new Date(), "blizzard storm", "South Park", 312);
        System.out.println(fmt);
    }
}
