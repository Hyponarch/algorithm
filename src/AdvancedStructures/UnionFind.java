package AdvancedStructures;

/**
 * 并查集，用于求解连通分量的数目（count），或者判断连通性（需要连通的节点的根节点是否一致）
 */
public class UnionFind {
    int[] parent;
    int[] rank;
    int count;

    /**
     * 查找根节点
     * O(h)，由于执行路径压缩，h接近是常数级别的大小，实际上是O(log* n)
     * log* n为迭代log，α(n)反阿克曼函数，宇宙粒子范围内不会超过5
     * log*(n) = 0 , n<=1
     *           1 + log*(log(n)), n>1
     * @param i 查询的节点
     * @return  根节点
     */
    int find(int i){
        //如果不是根节点
        if(parent[i] != i){
            //递归调用查找父节点，直到根节点。并且在此过程中，将根节点的孙节点（和孙节点的子孙）连接到根节点（路径压缩），加快查询效率
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    /**
     * 合并2个节点到一棵树
     * 执行n次union
     * @param x 节点1
     * @param y 节点2
     */
    void union(int x, int y){
        //合并x和y，即合并其根节点
        int rootX = find(x);
        int rootY = find(y);

        //如果不在一个子树，则进行合并
        //按秩合并，总是将秩较小的树合并到秩较大的树，尽量避免增加树的高度，树高越小，则查询效率越高
        if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }else if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            }else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            count--;
        }
    }

    /**
     * 初始化
     * @param n 节点数
     */
    public UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
/*            rank[i] = 0;*/
//            count++;
        }
        count = n;
    }


}
