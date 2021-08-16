package LeetCode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    @Override
    public String toString(){
        return "val: "+ this.val +
                ", l: " + (this.left == null ? "null" : this.left.val)+
                ", r: " +  (this.right == null ? "null" : this.right.val);
    }
}