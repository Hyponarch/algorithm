package LeetCode;

import java.util.*;

public class Problem_783 {
    public static void main(String[] args) {
        Solution s = new Problem_783().new Solution();

    }
    class Solution {
        List<Integer> list = new ArrayList<>();
        public int minDiffInBST(TreeNode root) {
            preorder(root);
            Collections.sort(list);
            int min = Integer.MAX_VALUE;
            for(int i = 1; i < list.size(); i++){
                min = Math.min(Math.abs(list.get(i) - list.get(i - 1)), min);
            }
            return min;
        }
        void preorder(TreeNode root){
            if(root == null){
                return;
            }
            list.add(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }
}
