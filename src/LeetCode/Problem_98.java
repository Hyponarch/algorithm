package LeetCode;

public class Problem_98 {
    public static void main(String[] args) {
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_7 = new TreeNode(7);
        TreeNode node_6 = new TreeNode(6, node_3, node_7);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(5, node_4, node_6);
        Problem_98 p = new Problem_98();
        Solution s = p.new Solution();
        s.isValidBST(node_5);

    }
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if(root==null){
                return true;
            }

            if(root.left!=null){
                if(root.left.val<root.val){
                    if(!isValidBST(root.left)){
                        return false;
                    }
                }else{
                    return false;
                }
            }
            if(root.right!=null){
                if(root.right.val>root.val){
                    if(!isValidBST(root.right)){
                        return false;
                    }
                }else{
                    return false;
                }
            }
            return true;
        }
    }
}
