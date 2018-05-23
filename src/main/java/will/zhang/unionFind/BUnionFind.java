package will.zhang.unionFind;

/**
 * 第二版的并查集(Quick Union)
 * 这次是使用数组来表示一棵树, 无论isConnected(p, q)和unionElements(p, q)都是O(h)的时间复杂度, h是树所属集合那棵树的高度
 */
public class BUnionFind implements UF {

    //parnet[i]代表它所指向的节点
    private int[] parent;

    public BUnionFind(int size){
        parent = new int[size];
        //初始化的时候每一个节点都指向自己, 也就是每一个节点都是一棵独立的树
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查看p和q是否属于同一个集合
     * 时间复杂度O(h), p是树的高度
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属的集合
     * 时间复杂度O(h), p是树的高度
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot) return;

        parent[pRoot] = parent[qRoot];
    }

    /**
     * 查询p所对应的集合编号
     * 时间复杂度O(h), p是树的高度
     * @param p
     * @return
     */
    private int find(int p){
        if(p < 0 || p >= parent.length){
            throw new IllegalArgumentException("p is out of bound");
        }
        while(p != parent[p]){
            p = parent[p];
        }
        return p;
    }
}
