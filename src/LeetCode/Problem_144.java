package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Problem_144 {
    //这题是最经典的二叉树的遍历-先序遍历
    //二叉树的深度优先遍历有先序遍历、中序遍历、后序遍历等
    //不管哪种遍历方式，都是从左往右的，所谓的先、中、后的区别是指遍历根节点的顺序
    //先序遍历是指先遍历根节点、再遍历左子树，最后遍历右子树，即根、左、右
    //中序遍历是指先遍历左子树、再遍历根节点、最后遍历右子树，即左、根、右
    //后续遍历是指先遍历左子树、再遍历右子树、最后遍历根节点，即左、右、根
    //不论是哪种方式，一定是先左后右，改变的只有根节点的顺序
    //二叉树的定义：二叉树要么是一棵空树，要么是由一棵非空的根节点与左、右子树构成的树，其左、右子树也是二叉树
    //由定义可知，二叉树是一种天然的递归结构，自然也很适合用递归来实现
    class Solution {
        //解法1，递归法
        List<Integer> ans = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            preorder(root);
            return ans;
        }
        //递归的几个核心步骤：
        //1、递归终止条件: 标志递归的结束，防止无限递归调用，导致栈溢出。而递归的终止，往往也是问题分解到最小的时候
        //2、当前步骤的处理：相当于迭代步骤中的循环执行的代码
        //3、递归调用：将当前的问题分解成更小的部分来解决
        void preorder(TreeNode root){
            //递归终止条件，遍历到空节点（叶节点的子节点）
            if(root == null){
                return;
            }
            //先访问根节点
            ans.add(root.val);
            //递归访问左子树
            preorder(root.left);
            //递归访问左子树
            preorder(root.right);
        }
        //解法2，迭代
        public List<Integer> preorderTraversal1(TreeNode root) {
            //迭代需要保存中间访问过的根节点，以便回头去访问它们的左右子树
            //而且是先访问后来的根节点的左右子树，即后进先出，也就是栈结构
            //java中，不用Stack来实现栈的原因是Stack是一个线程安全但效率低下的实现，现在已经被弃用
            //现在栈一般用Deque接口，LinkedList实现。
            Deque<TreeNode> stack = new LinkedList<>();
            //当前访问节点
            TreeNode curr = root;
            //栈里存的节点表示“子树还未被访问”的节点
            //当栈不为空时，表示还有未访问的子树（可能为空），curr != null则表示即使栈为空，但当前节点仍是未访问过的节点，初始状态就是如此
            while (!stack.isEmpty() || curr != null){
                //当前节点不为空时
                while (curr != null){
                    //先遍历根节点
                    ans.add(curr.val);
                    //根节点写入栈，与根节点写入的顺序相反访问它们的子树
                    stack.push(curr);
                    //一直向左，直到最左叶节点
                    curr = curr.left;
                }
                //到达最左叶节点后，表示当前子树的根节点和左子树均已访问
                curr = stack.pop();
                //于是取出根节点，访问右子树
                curr = curr.right;

            }
            return ans;
        }
    }
}
