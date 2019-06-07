package com.hzways.map;

import java.util.HashMap;
import java.util.Map;

/**
 * desc: GraceMap
 *
 * @author hz.lei
 * @since 2018年07月28日 下午3:46
 */
public class GraceMap {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 1. 数组 + 链表
     * 数组存储区间连续,占用内存严重，空间复杂度大。
     * 但数组的二分查找时间复杂度小，为O(1)；数组的特点是：寻址容易，插入和删除困难；
     * 2.链表存储区间离散，占用内存比较宽松，故空间复杂度很小，但时间复杂度很大，达O（N）。
     * 链表的特点是：寻址困难，插入和删除容易
     */
    public static void main(String[] args) {
        // 16 to 1073741824
        GraceMap map = new GraceMap();

        HashMap<Integer, String> testMap = new HashMap<>(3);

        testMap.put(1, "大佬权");
        testMap.put(2, "大佬权2");

        String value = testMap.get(1);

        System.out.println(value);

        int i = tableSizeFor(6);
        System.out.println(i);


    }

    private static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
