package LeetCode;

import java.util.*;

public class Problem_78 {

    public static void main(String[] args) {
        Solution s = new Problem_78().new Solution();
        System.out.println(s.subsets(new int[]{1, 2, 3}).toString());
    }
    /*
    //迭代，每次为所有子集加上当前元素构成新子集，将新子集加入答案
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<Integer>());
            for (int num : nums) {
                List<List<Integer>> tmp = new ArrayList<>();
                for (List<Integer> l : ans) {
                    List<Integer> t = new ArrayList<>(l);
                    t.add(num);
                    tmp.add(t);
                }
                ans.addAll(tmp);
            }
            return ans;
        }
    }
    */

    //迭代，每次为所有子集加上当前元素构成新子集，将新子集加入答案
    //用ListIterator遍历
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<Integer>());
            for (int num : nums) {
                ListIterator<List<Integer>> it = ans.listIterator();
                while (it.hasNext()){
                    List<Integer> tmp = new ArrayList<>(it.next());
                    tmp.add(num);
                    it.add(tmp);
                }
            }
            return ans;
        }
    }

    /*
    //dfs，根据长度来计算所有子集
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {

            List<List<Integer>> ans = new ArrayList<>();
            for(int i = 0; i < nums.length + 1; i++){
                Set<Integer> path = new HashSet<>();
                dfs(nums, path, ans, i, 0);
            }
            return ans;

        }

        void dfs(int[] nums, Set<Integer> path, List<List<Integer>> ans, int len, int idx){
            if(path.size() == len){
                ans.add(new ArrayList<>(path));
                return;
            }
            for(int i = idx; i < nums.length; i++){
                if(!path.contains(nums[i])){
                    path.add(nums[i]);
                    //为了避免重复，不应当使用更前面的数字
                    dfs(nums, path, ans, len, i + 1);
                    path.remove(nums[i]);
                }
            }
        }
    }
    */
}
