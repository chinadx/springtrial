package cn.goodman.collections;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Shaun on 2017/2/24.
 */
public class WordMap {

    public static void main(String[] args) {
        Map<String, Integer> wordMap = readFile("C:\\Users\\Shaun\\OneDrive\\Documents\\Hulu\\JD.txt");
        System.out.println(wordMap.toString());
        List<Map.Entry<String, Integer>> list = sortWordsInDecreasing(wordMap);
        for(Map.Entry<String, Integer> word : list) {
            System.out.println(word.getKey() + "-->" + word.getValue());
        }
    }

    /**
     * 读入文件，返回文件中的单词统计Map
     * @param fileName
     * @return map with words
     */
    public static Map<String, Integer> readFile(String fileName) {
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));
            Pattern pattern = Pattern.compile("\\s+");
            String line = null;
            while((line = br.readLine()) != null) {
                line = line.toLowerCase();
                String[] words = pattern.split(line);
                for(String word : words) {
                    if(wordMap.containsKey(word)) {
                        wordMap.put(word, wordMap.get(word)+1);
                    } else {
                        wordMap.put(word, 1);
                    }
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return wordMap;
    }

    /**
     * 将Map按照value大小排序
     * @param wordMap
     * @return 排序后的数组
     */
    public static List<Map.Entry<String, Integer>> sortWordsInDecreasing(Map<String, Integer> wordMap) {
        Set<Map.Entry<String, Integer>> entries = wordMap.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entries);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return list;
    }
}
