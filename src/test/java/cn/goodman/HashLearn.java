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

        Integer a = 1;
        long start = 0;
        long end = 0;
        // 先垃圾回收
        System.gc();
        start = Runtime.getRuntime().freeMemory();
        HashMap map = new HashMap();
        for (int i = 0; i < 1000000; i++) {
            map.put(i, a);
        }
        // 快要计算的时,再清理一次
        System.gc();
        end = Runtime.getRuntime().freeMemory();
        System.out.println("一个HashMap对象占内存:" + (end - start));
    }
}
