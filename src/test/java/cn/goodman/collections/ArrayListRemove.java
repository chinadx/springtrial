package cn.goodman.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Shaun on 2017/2/24.
 */
public class ArrayListRemove {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(200);
        for(int i=0; i<=100; i++) {
            list.add(i);
        }
        System.out.println(list.toString());

        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()) {
            Integer f = iter.next();
            System.out.println(f);
            if(f.intValue() % 4 == 0) {
                System.out.println("删除" + f);
                iter.remove();
            }
        }

        System.out.println(list.toString());
    }
}
