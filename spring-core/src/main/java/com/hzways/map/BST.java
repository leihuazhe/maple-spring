package com.hzways.map;

/**
 * desc: 二叉查找树
 *
 * @author hz.lei
 * @since 2018年07月29日 下午1:48
 */
public class BST<Key extends Comparable<Key>, Value> {
    /**
     * 二叉查找树根节点
     */
    private Node root;

    private class Node {
        /**
         * 键
         */
        private Key key;
        /**
         * 值
         */
        private Value val;
        /**
         * 指向子树的链接
         */
        private Node left, right;
        /**
         * 以该节点为根的子树中的节点总数
         */
        private int n;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) return 0;
        else return x.n;
    }

    public Value get(Key key) {
        return get(root, key);

    }

    /**
     * 在 以 x 为根节点的 子树中查找并返回key所对应的值
     *
     * @param x
     * @param key
     * @return
     */
    public Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;

    }

    /**
     * 查找key，找到则更新它的值，否则为它创建一个新的节点
     *
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        root = put(root, key, val);

    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }


}
