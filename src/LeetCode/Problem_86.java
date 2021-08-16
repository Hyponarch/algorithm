package LeetCode;

public class Problem_86 {
    public static void main(String[] args) {
        Problem_86 prob = new Problem_86();
        Solution s = prob.new Solution();
        //[1,4,3,2,5,2]
        //3
        ListNode l5 = prob.new ListNode(2);
        ListNode l4 = prob.new ListNode(5, l5);
        ListNode l3 = prob.new ListNode(2, l4);
        ListNode l2 = prob.new ListNode(3, l3);
        ListNode l1 = prob.new ListNode(4, l2);
        ListNode l0 = prob.new ListNode(1, l1);
        ListNode ans = s.partition(l0, 3);
        while (ans!=null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        @Override
        public String toString(){

            StringBuffer sb = new StringBuffer();
            sb.append(this.val);
//            if(null==this.next){
//                return sb.toString();
//            }
            ListNode tmp = this;
            while (tmp.next!=null){
                sb.append(",");
                tmp = tmp.next;
                sb.append(tmp.val);
            }
            return sb.toString();
        }
    }

    class Solution {
        public ListNode partition(ListNode head, int x) {
//            ListNode p1=new ListNode(-1);
//            p1.toString();
//            ListNode p1Tail = p1;
//            ListNode p2 = new ListNode(-2);
//            ListNode p2Tail = p2;
//            while(head!=null){
//                if(head.val < x){
//                    p1Tail.next = head;
//                    p1Tail = p1Tail.next;
//                }else{
//                    p2Tail.next = head;
//                    p2Tail = p2Tail.next;
//                }
//                head = head.next;
//            }
//            //最后要断开链接，防止成环
//            p2Tail.next =null;
//            p1Tail.next = p2.next;
//            return p1.next;

//            除x以外有序
//            快排的步骤？比pivot小的，放前面，大的后面
//            找到第一个大于等于x的节点（x除外？），然后在这之后找到第一个小于x的节点，交换
             ListNode big = head;
             ListNode pre = new ListNode(-1, head);
             while(big!=null){
                 //找到第一个大于等于x的节点，然后从这里开始找小于x的节点

                 if(big.val >= x){
                     ListNode smallPre = big;
                     ListNode small = big.next;
                     while(small!=null){
                         if(small.val < x){
                             ListNode next = small.next;

                             pre.next = small;
                             small.next = big.next;
                             smallPre.next = big;
                             big.next = next;

                             big = small;

                             break;
                         }
                         small = small.next;
                         smallPre = smallPre.next;
                     }
                 }
                 big = big.next;
                 pre = pre.next;
             }
             return head;
        }
    }
}

