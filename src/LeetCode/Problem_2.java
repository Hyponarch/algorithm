package LeetCode;

public class Problem_2 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //虚拟头节点
            ListNode dummy = new ListNode();
            //当前节点指针
            ListNode curr = dummy;
            //进位
            int carry = 0;
            //只要有一个数没遍历完，就继续执行
            while (l1 != null || l2 != null){
                //通过安全方法取值
                int res = getOrDefault(l1, 0) + getOrDefault(l2, 0) + carry;
                //不讨论res的值，直接计算进位
                carry = res / 10;
                //res % 10为当前位的值
                curr.next = new ListNode(res % 10);
                //节点后移
                curr = curr.next;
                //为空则不后移
                if(l1 != null){
                    l1 = l1.next;
                }
                if(l2 != null){
                    l2 = l2.next;
                }
            }
            if(carry != 0){
                curr.next = new ListNode(carry);
            }
            return dummy.next;
        }
        //安全取值方法，避免节点为null的讨论
        int getOrDefault(ListNode node, int defaultValue){
            return node == null ? defaultValue : node.val;
        }
    }
}
