package LeetCode;

public class Problem_328 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tail = head;
        for(int i=1; i<5; i++){
            tail.next = new ListNode(i+1);
            tail = tail.next;
        }
        Solution s = new Problem_328().new Solution();
        ListNode ans = s.oddEvenList(head);
        while(ans!=null){
            System.out.print(ans.val);
            ans = ans.next;
        }
    }
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if(head == null){
                return null;
            }
            //odd奇数，even偶数

            ListNode oddHead = new ListNode();
            ListNode evenHead = new ListNode();
            ListNode oddTail = oddHead;
            ListNode evenTail = evenHead;
            while(head!=null){
                oddTail.next = head;
                oddTail = oddTail.next;
                head = head.next;
                evenTail.next = head;
                if(head!=null){
                    head = head.next;
                    evenTail = evenTail.next;
                }
            }
            oddTail.next = evenHead.next;
            return oddHead.next;
        }
    }
}
