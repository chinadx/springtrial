package cn.goodman.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Shaun on 2017/2/27.
 */
public class ListSort {
    public static void main(String[] args) {
        String sentience = "Hi all, I am a smart clever cute handsome student.";
        Pattern pattern = Pattern.compile("\\s+");
        String[] words = pattern.split(sentience);
        List<String> wa = new ArrayList<>();
        for(String word : words) {
            wa.add(word);
        }
        System.out.println(wa.toString());
        /**
         * 排序方法一
         * 重写sort方法，包含compare的重载
         */
        wa.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        /**
         * 排序方法二
         * 直接使用Collections.sort方法
         */
//        Collections.sort(wa);
        System.out.println(wa.toString());
    }
}
