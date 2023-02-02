package com.wltt.basic;

import java.util.Arrays;

/**
 * author: brett
 * data: 2020/7/7
 * description:
 */
public class SingletonLink {

    static class Node {
        int num;
        Node next;

        public Node(int num, Node next) {
            this.num = num;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node p = new Node(1, new Node(2, new Node(3, new Node(4, null))));
//        printf(p);
//        p = transfer(p);
//        printf(p);
//        printf(recursion(p));
        int[] arr = new int[]{ 3, 5, 4, 6, 1 };
//        sort(arr);
        QKSort(arr ,0,arr.length-1);
        traverse(arr);

    }

    private static void printf(Node node) {
        Node e = node;
        while (e != null) {
            System.out.println(e.num);
            e = e.next;
        }
    }

    /**
     * 就地反转 O(1)
     */
    private static Node transfer(Node node) {
        if (node == null) {
            return null;
        }
        Node preNode = null;
        while (node != null) {
            Node nextNode = node.next;
            node.next = preNode;
            preNode = node;
            node = nextNode;

        }
        return preNode;
    }

    /**
     * 递归反转 O(n^2)
     */
    private static Node recursion(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node headNode = recursion(node.next);
        node.next.next = node;
        node.next = null;
        return headNode;
    }

    /**
     * 选择排序 O()
     */
    private static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    /**
     * 插入排序
     */
    private static void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * 希尔排序-插入排序变种
     */
    private static void xrSort(int[] array) {
        int n = array.length;
        int h = 1;
        while (h<n/3) { //动态定义间隔序列
            h = 3*h +1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && (array[j] < array[j - h]); j -= h) {
                    int temp = array[j];
                    array[j] = array[j - h];
                    array[j-h]= temp;
                }
            }
            h /=3;
        }
    }

    /**
     * 快速排序
     */
    private static void QKSort(int[] a, int start, int end) {
        if (a.length < 0){
            return ;
        }
        if (start >= end){
            return ;
        }
        int left = start;
        int right = end;
        int temp = a[left];
        while (left < right){
            while (left < right && a[right] > temp){
                right -- ;
            }
            a[left] = a[right];
            while (left < right && a[left] < temp){
                left ++ ;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        System.out.println(Arrays.toString(a));
        QKSort(a, start, left -1);
        QKSort(a,left+1,end);
    }

    /**
     * 遍历数组
     */
    private static void traverse(int[] arr) {
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
