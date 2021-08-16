package LeetCode;

public class Problem_200 {

    class Solution {
        public int numIslands(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            UnionFind uf = new UnionFind(grid);
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == '1'){
                        if(j + 1 < n && grid[i][j+1] == '1'){
                            uf.union(i * n + j, i * n + j + 1);
                        }
                        if(i + 1 < m && grid[i+1][j] == '1'){
                            uf.union(i * n + j, (i + 1) * n + j);
                        }
                    }
                }
            }
            return uf.count;
        }

        class UnionFind{
            int[] parent;
            int[] rank;
            int count;
            //找根节点
            int find(int i){
                //如果一个节点的父节点不是他自己，那么他的父节点就不是根节点，这里是if，递归调用，不是while循环
                if (parent[i] != i){
                    parent[i] = find(parent[i]);
                }
                return parent[i];
            }
            //
            void union(int x, int y){
                int rootX = find(x);
                int rootY = find(y);
                if(rootX != rootY){
                    if(rank[rootX] > rank[rootY]){
                        parent[rootY] = rootX;
                    }else if(rank[rootX] < rank[rootY]){
                        parent[rootX] = rootY;
                    }else {
                        parent[rootY] = parent[rootX];
                        rank[rootX]++;
                    }
                    count--;
                }
            }
            public UnionFind(char[][] grid){
                int m = grid.length;
                int n = grid[0].length;
                parent = new int[m * n];
                rank = new int[m * n];
                for(int i = 0; i < m; i++){
                    for(int j = 0; j < n; j++){
                        if(grid[i][j] == '1'){
                            parent[i * n + j] = i * n + j;
                            count++;
                        }
                    }
                }
            }
        }
    }

}
