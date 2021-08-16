package test;

import java.util.*;

public class DFS {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);

        int[] nums = new int[]{1,4,4};
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
//        Set<Integer> visit = new HashSet<>();
        boolean[] visit = new boolean[nums.length];
        dfs(nums, path, visit);

    }
    static void dfs(int[] nums, List<Integer> path, boolean[] visit){
        if(path.size() == nums.length){
            System.out.println(path.toString());
        }
        for(int i = 0; i < nums.length; i++){
            if(visit[i]){
                continue;
            }
            if(i != 0 && !visit[i-1] && nums[i] == nums[i-1]){
                continue;
            }

            visit[i] = true;
            path.add(nums[i]);
            dfs(nums, path, visit);
            visit[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
