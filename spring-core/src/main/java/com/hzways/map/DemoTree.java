package com.hzways.map;

/**
 * desc: DemoTree
 *
 * @author hz.lei
 * @since 2018年07月29日 下午12:41
 */
public class DemoTree {
    private int size;
    private int[] tree;

    public DemoTree(int size) {
        this.size = size;
        this.tree = new int[size];
        int i = 0;
        for (i = 0; i < size; i++) {
            tree[i] = 0;
        }
    }

    public int searchNode(int nodeIndex) {
        if (nodeIndex <0 || nodeIndex >=size){
            return 0;
        }


        return tree[nodeIndex];
    }






}
