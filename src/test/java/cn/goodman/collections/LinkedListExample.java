package cn.goodman.collections;

import java.util.*;

/**
 * Created by Shaun on 2017/2/28.
 */
public class LinkedListExample {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("doggie");
        list.add("cattie");
        list.add("donkey");
        list.add("tiger");
        list.add("cattie");
        list.add("doggie");
        list.add("cattie");
        System.out.println(list.toString());

        Map<String, String> map = new HashMap<>();
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()) {
            String key = iter.next();
            if(map.containsKey(key)) {
                System.out.println("包含重复数据：" + key);
                iter.remove();
            }
            map.put(key, "");
        }

        System.out.println(list.toString());
    }
}
