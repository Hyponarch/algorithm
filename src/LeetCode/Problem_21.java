package LeetCode;

/**
 * @description:
 * @author: luchenl.chen
 * @email: luchenl.chen@qunar.com
 * @date: 2021/8/11 12:25
 * @version: 1.0
 */
public class Problem_21 {
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //虚拟头结点，避免null讨论
            ListNode dummy = new ListNode();
            //当前结点指针
            ListNode curr = dummy;
            //如果2个链表都未遍历完
            while(l1 != null && l2 != null){
                //将较小的数连接到curr后
                if(l1.val <= l2.val){
                    curr.next = l1;
                    l1 = l1.next;
                }else {
                    curr.next = l2;
                    l2 = l2.next;
                }
                //curr向后移
                curr = curr.next;
            }
            //如果有未处理完的部分直接全部连接到curr后
            if(l1 != null){
                curr.next = l1;
            }else {
                curr.next = l2;
            }
            //返回虚拟头结点后的节点
            return dummy.next;
        }
    }
}
