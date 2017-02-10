package cn.goodman;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shaun on 2017/2/10.
 */
public class HashLearn {
    public static void main(String args[]) {
        String str = "ABCDEFG";
        System.out.println(str.hashCode());

        Map<String, String> mp = new HashMap<String, String>();
        mp.put("a", "asd");
        mp.put("a", "kkk");
        System.out.println(mp.toString());
    }
}
