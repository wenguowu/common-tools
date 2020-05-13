package com.wltt.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * author: wlt
 * date: 2019/12/12
 * description:
 */
public class WltHashMap {
    public static void main(String[] args) {
        Entry<String, Object> entr2 = new Entry<String, Object>(132, "test2", "2");
        Entry<String, Object> entr1 = new Entry<String, Object>(131, "test1", "1");
        Entry<String, Object> entr = new Entry<String, Object>(13, "test", "0");
        entr.next = entr1;
        entr1.next = entr2;

        printLink(entr);

        printLink(transfer(entr));

    }


    static class Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Entry<K, V> next;

        Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    static void printLink(Entry<String, Object> entry) {
        while (entry != null) {
            System.out.println("key:" + entry.key + "," + "value:" + entry.value);
            entry = entry.next;
        }
    }

    static Entry transfer(Entry<String, Object> entry) {


        Entry<String, Object> e = null;

        while (entry != null) {
            Entry temp = entry.next;
            entry.next = e;
            e = entry;
            entry = temp;
        }
        return e;
    }
}
