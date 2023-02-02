package com.wltt.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * author: wlt
 * data: 2019/12/19
 * description: LRU 实现
 */
public class LRUHashMap<K, V> extends LinkedHashMap<K, V> {

    private static final int MAX_SIZE = 4;

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_SIZE;
    }


    public static void main(String[] args) {
        Map<String, Object> lruHashMap = new LRUHashMap<String, Object>();
        lruHashMap.put("t1", "1");
        lruHashMap.put("t2", "2");
        lruHashMap.put("t3", "3");
        lruHashMap.put("t4", "4");
        System.out.println(lruHashMap.toString());
        lruHashMap.put("t5", "5");
        System.out.println(lruHashMap.toString());
    }
}
