package cn.goodman.collections;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Shaun on 2017/2/28.
 */
public class TreeMapExample {
    public static void main(String[] args) {
        Map<String, Integer> persons = new TreeMap<>();
        persons.put("John McRein", 35);
        persons.put("Keithrine Lynken", 27);
        persons.put("Angilina Juliet", 22);
        persons.put("Brard Peter", 25);
        System.out.println(persons.toString());
    }
}
