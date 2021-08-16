package LeetCode;

import java.util.*;

public class Problem_114 {
    public static void main(String[] args) {
        Solution s = new Problem_114().new Solution();
        TreeNode node_0 = new TreeNode(3);
        TreeNode node_1 = new TreeNode(4);
        TreeNode node_2 = new TreeNode(2, node_0, node_1);
        TreeNode node_3 = new TreeNode(6);
        TreeNode node_4 = new TreeNode(5, null, node_3);
        TreeNode node_5 = new TreeNode(1, node_2, node_4);
        //TreeNode node_6 = new TreeNode(5, node_4, node_6);
        s.flatten(node_5);
        int a= 1;
        //[1,2,5,3,4,null,6]
    }
    class Solution {
        //TreeNode pre;
        public void flatten(TreeNode root) {
            TreeNode head = new TreeNode();
            TreeNode[] pre = new TreeNode[]{head};
            preOrder(root, pre);

            Queue<TreeNode> q = new LinkedList<>();

            //将所有的左孩子变为右孩子，并让左孩子指针置空
            while(head!=null){
                head.right = head.left;
                head.left = null;
                head = head.right;
            }

        }
        //进行一次先序遍历，记录前一个节点，将所有节点按先序遍历的方式放到左孩子
        //使用一个引用将pre节点包装一下，就可以实现跨递归层修改，因为如果不包装，等于修改引用，无法返回给上层
        //也可以使用全局变量（成员变量）
        void preOrder(TreeNode root, TreeNode[] pre){
            if(root == null){
                return;
            }
            //将上一个节点的left指向当前节点
            pre[0].left = root;
            //pre记录最后一个访问的节点
            pre[0] = root;
            if(root.left != null){
                preOrder(root.left, pre);
            }
            if(root.right != null){
                preOrder(root.right, pre);
            }
        }
    }
}
