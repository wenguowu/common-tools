package com.wltt.synchronize;

/**
 * author: brett
 * data: 2020/11/20
 * description:
 */
public class TestSynchronize {
    public static void main(String[] args) {
        Object o = new Object();
        synchronized(o){
            System.out.println("test");
        }
    }
}
