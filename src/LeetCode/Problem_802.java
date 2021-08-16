package LeetCode;

import java.util.*;

public class Problem_802 {
    class Solution {
        int[] isSafe;
        Set<Integer> visit = new HashSet<>();
        Set<Integer> path = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        public List<Integer> eventualSafeNodes(int[][] graph) {
            //终点集，set，无出边
            //isSafe数组，该点是安全的
            //path，set，已途经的节点
            int m = graph.length;
            isSafe = new int[m];    //1安全，0默认，-1不安全

            path = new HashSet<>();
            for(int i = 0; i < m; i++){
                if(graph[i].length == 0){
                    visit.add(i);
                    isSafe[i] = 1;
                }
            }
            for(int i = 0; i < m; i++){
                if(isSafe[i] == 1){
                    continue;
                }
                dfs(i, graph);
            }
            Collections.sort(ans);
            return ans;
        }

        void dfs(int curr, int[][] graph){
            if(visit.size() == graph.length){
                return;
            }
            path.add(curr);
            if(isSafe[curr] == 1){
                ans.add(curr);
                path.remove(curr);
                return;
            }
            for(int i = 0; i < graph[curr].length; i++){
                int num = graph[curr][i];

                if(path.contains(num) || isSafe[num] == -1){
                    continue;
                }
                path.add(num);
                if(isSafe[num] == 1){
                    for(int p : path){
                        ans.add(p);
                        isSafe[p] = 1;
                        visit.add(p);
                    }

                    path.remove(curr);
                    return;
                }else{
                    dfs(num, graph);
                }
            }
            if(isSafe[curr] == 0){
                isSafe[curr] = -1;
            }
            path.remove(curr);
        }
    }
}
