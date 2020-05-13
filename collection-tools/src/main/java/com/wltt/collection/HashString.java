package com.wltt.collection;

/**
 * author: wlt
 * data: 2019/12/12
 * description:
 */
public class HashString {

    public int hashCode() {
        return 1;
    }

    public boolean euqals(Object object) {
        return true;
    }

    public static void main(String[] args) {
        boolean a = true;
        boolean b = true;

        System.out.println(!(a|b));
        System.out.println(!a&!b);
        System.out.println((a|b));
    }
}
