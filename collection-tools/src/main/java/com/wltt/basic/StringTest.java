package com.wltt.basic;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * author: brett
 * data: 2020/7/5
 * description:
 */
public class StringTest {
    public static void main(String[] args) {
        String s0 = "equal";
        String s1 = "eq";
        String s2 = "ual";
        String s3 = "eq" + "ual";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);

        Predicate<Integer> a = x -> x > 10;

        System.out.println(a.test(11));

        Function<String,Boolean> function = x->{
            return x.equals("test");
        };
        System.out.println(function.apply("test1"));

        Supplier<HashMap> supplier = HashMap::new;

        ThreadLocal threadLocal = ThreadLocal.withInitial(supplier);
        threadLocal.set(1);
        System.out.println(threadLocal.get());

    }
}
