package interview;

import java.util.*;

/**
 1
 4 4
 1 2
 1 3
 1 4
 2 3

 1
 4 4
 1 2
 2 3
 3 4
 1 4

 2
 4 4
 1 2
 1 3
 1 4
 2 3
 4 4
 1 2
 2 3
 3 4
 1 4

 */
public class Didi_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groupNum = sc.nextInt();
        for(int i = 0; i < groupNum; i++){
            int n = sc.nextInt();   //顶点数
            int m = sc.nextInt();   //边数

            int[][] edges = new int[n][2];
            for(int j = 0; j < m; j++){
                edges[j] = new int[]{sc.nextInt(), sc.nextInt()};
            }
            boolean right = true;
            for(int j = 0; j < m; j++){
                UnionFind uf = new UnionFind(n);
                for(int k = 0; k < m; k++){
                    if(k == j){
                        continue;
                    }
                    uf.union(edges[k][0] - 1, edges[k][1] - 1);
                }
                if(uf.count != 1){
                    System.out.println("No");
                    right = false;
                    break;
                }
            }
            if(right){
                System.out.println("Yes");
            }
        }
    }

    static class UnionFind {
        int[] parent;
        int count;
        int[] rank;

        int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY){
                if(rank[rootX] > rank[rootY]){
                    parent[rootY] = rootX;
                }else if(rank[rootX] < rank[rootY]){
                    parent[rootX] = rootY;
                }else{
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            }
        }

        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            count = n;
            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }
    }
}
