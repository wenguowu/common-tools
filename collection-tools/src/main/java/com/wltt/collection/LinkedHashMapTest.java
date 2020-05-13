package com.wltt.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * author: wlt
 * data: 2019/12/17
 * description:
 */
public class LinkedHashMapTest extends HashMap {


    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("test1");
        linkedHashSet.add("test2");
        HashSet hashSet = new HashSet(linkedHashSet);
    }
}
