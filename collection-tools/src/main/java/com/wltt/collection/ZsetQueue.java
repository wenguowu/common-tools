package com.wltt.collection;

import com.sun.tools.javac.util.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Supplier;

/**
 * author: wlt
 * data: 2019/12/19
 * description: 延迟队列-ZSET 实现
 */
public class ZsetQueue {
    /*
      1、先进先出
      2、界限
      3、
    */

    private HashString hashString = new HashString();

    public void printf() {
        System.out.println("ZsetQueue");
        System.out.println();
    }

    static {
        System.out.println("I am real unique!");
    }

    public static <R> R notNullAndSuit(Object o, Supplier<R> supply) {
        Assert.checkNull(o);
        return supply.get();
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ZsetQueue zsetQueue = new ZsetQueue();
        System.out.println(zsetQueue.getClass().getClassLoader().getClass().getName());
        zsetQueue.printf();

        ZsetQueue zsetQueue1 = new ZsetQueue();
        System.out.println(zsetQueue1.getClass().getClassLoader().getClass().getName());
        zsetQueue1.printf();

        ClassLoader classLoader = new MyClassLoader("/JAVA_Files/");
        Class aClass = classLoader.loadClass("com.wltt.collection.ZsetQueue");
        System.out.println(aClass.getClassLoader());
        Object o = aClass.newInstance();
        Method method = o.getClass().getMethod("printf");
        method.invoke(o);

        ClassLoader classLoader1 = new MyClassLoader("/JAVA_Files/test/");
        Class aClass1 = classLoader1.loadClass("com.wltt.collection.ZsetQueue");
        System.out.println(aClass1.getClassLoader());
        Object o1 = aClass1.newInstance();
        Method method1 = o1.getClass().getMethod("printf");
        method1.invoke(o1);

    }

    static class MyClassLoader extends ClassLoader {

        private String path;

        public MyClassLoader(String path) {
            this.path = path;
        }

        private byte[] loadByte(String name) throws IOException {
            name = name.replaceAll("\\.", "/");
            FileInputStream fs = new FileInputStream(path + name + ".class");
            int len = fs.available();
            byte[] data = new byte[len];
            fs.read(data);
            fs.close();
            return data;
        }

        @Override
        protected Class<?> findClass(String name) {
            try {
                byte[] data = loadByte(name);
                return defineClass(name, data, 0, data.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {

            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    if (!name.startsWith("com.wltt.collection.ZsetQueue")) {
                        c = this.getParent().loadClass(name);
                    } else {
                        c = findClass(name);
                    }
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }
    }
}
