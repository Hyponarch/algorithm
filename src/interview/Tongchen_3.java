package interview;

import java.util.Map;

public class Tongchen_3 {
    //模拟
    //可以通过找到递增、递减子序列来判断
    public class Solution {
        /**
         * 返回根据arr中元素顺序构成二叉搜索树的树层级
         * @param arr int整型一维数组 无序且无数值重复的数组
         * @return int整型
         */
        public int tdepth (int[] arr) {
            // write code here
            Node root = new Node(arr[0]);
            Node node;
            int maxDepth = 1;
            for(int i = 1; i < arr.length; i++){
                node = root;
                int depth = 1;
                while(true){
                    depth++;
                    if(arr[i] <= node.val){
                        if(node.left != null){
                            node = node.left;
                        }else {
                            node.left = new Node(arr[i]);
                            maxDepth = Math.max(maxDepth, depth);
                            break;
                        }
                    }else {
                        if(node.right != null){
                            node = node.right;
                        }else {
                            node.right = new Node(arr[i]);
                            maxDepth = Math.max(maxDepth, depth);
                            break;
                        }
                    }
                }

            }
            return maxDepth;
        }
        class Node{
            Node left;
            Node right;
            int val;
            public Node(){}
            public Node(int val){
                this.val = val;
            }
        }
    }
}
