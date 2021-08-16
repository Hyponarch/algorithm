package LeetCode;

import java.util.*;

public class Problem_5699 {

    public static void main(String[] args) {
        Solution s= new Problem_5699().new Solution();
        System.out.println(
        s.countRestrictedPaths(5, new int[][]{new int[]{1,2,3},new int[]{1,3,3},new int[]{2,3,1}
        ,new int[]{1,4,2},new int[]{5,2,2},new int[]{3,5,1},new int[]{5,4,10} })
        );
    }

    class Solution {
        int MAX_WEIGHT = Integer.MAX_VALUE;
        int count;
        public int countRestrictedPaths(int n, int[][] edges) {
            //求每个顶点的最短路径长度，受限路径为最短路径长度为严格递减序列
            //floyd算法
            int[][] matrix = new int[n][n];
            //初始化邻接矩阵
            for(int[] i : edges){
                matrix[i[0]-1][i[1]-1] = i[2];
                matrix[i[1]-1][i[0]-1] = i[2];
            }
            for(int[] i : matrix){
                for(int j = 0; j < n; j++){
                    if(i[j] == 0){
                        i[j] = MAX_WEIGHT;
                    }
                }
            }

            //路径矩阵（D），表示顶点到顶点的最短路径权值之和的矩阵，初始时，就是图的邻接矩阵。
            int[][] pathMatrix = new int[matrix.length][matrix.length];

            //初始化D,P
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    pathMatrix[i][j] = matrix[i][j];
                }
            }

            floyd(matrix, pathMatrix);

            for(int i = 0; i < n; i++){
                pathMatrix[i][i] = 0;
            }

            count = 0;

            List<Integer> path = new ArrayList<>();
            path.add(0);

            dfs(matrix, pathMatrix, path);

            return count;
        }
        void floyd(int[][] matrix, int[][] pathMatrix){

            //循环 中间经过顶点
            for (int k = 0; k < matrix.length; k++) {
                //循环所有路径
                for (int m = 0; m < matrix.length; m++) {

                    for (int n = 0; n < matrix.length; n++) {

                        int mn = pathMatrix[m][n];
                        int mk = pathMatrix[m][k];
                        int kn = pathMatrix[k][n];
                        int addedPath = (mk == MAX_WEIGHT || kn == MAX_WEIGHT)? MAX_WEIGHT : mk + kn;

                        if (mn > addedPath) {
                            //如果经过k顶点路径比原两点路径更短，将两点间权值设为更小的一个
                            pathMatrix[m][n] = addedPath;
                        }

                    }
                }
            }
        }

        void dfs(int[][] matrix, int[][] pathMatrix, List<Integer> path){
            int n = pathMatrix.length;
            if(path.get(path.size()-1) == n - 1){
                count++;
                return;
            }
            for(int i = 0; i < n; i++){
                if(matrix[i][path.get(path.size()-1)] != MAX_WEIGHT && pathMatrix[i][n-1] < pathMatrix[path.get(path.size()-1)][n-1]){
                    path.add(i);
                    dfs(matrix, pathMatrix, path);
                    path.remove(path.size()-1);
                }
            }
        }
    }
}
