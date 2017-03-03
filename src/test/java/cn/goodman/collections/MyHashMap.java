package cn.goodman.collections;

import java.util.Map;

/**
 * HashMap源码学习
 * http://www.cnblogs.com/ITtangtang/p/3948406.html
 * Created by Shaun on 2017/3/3.
 */
public class MyHashMap {
    /**
     * 键值对数组
     */
    transient Entry[] table;

    /**
     * 元素个数
     */
    transient int size;

    /**
     * 循环找到hashcode在一定长度的数组中的位置
     * @param h
     * @param length
     * @return
     */
    static int indexFor(int h, int length) {
        return h & (length-1);
    }

    /**
     * 键值对的内部类声明
     * @param <K>
     * @param <V>
     */
    static class Entry<K, V> implements Map.Entry{
        K key;
        V value;
        Entry<K, V> next;
        int hash;

        public Entry(K key, V value, Entry<K, V> next, int hash) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        @Override
        public int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry e = (Map.Entry)obj;
            Object key1 = getKey();
            Object key2 = e.getKey();
            if(key1 == key2 || (key1!=null) && key1.equals(key2)) {
                Object value1 = getValue();
                Object value2 = e.getValue();
                if(value1 == value2 || (value1 != null && value1.equals(value2))) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return getKey() + "=" + getValue();
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public Object setValue(Object value) {
            this.value = (V)value;
            return value;
        }
    }
}
