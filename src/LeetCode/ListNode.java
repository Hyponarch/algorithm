package LeetCode;

public class ListNode {
    int val;
    LeetCode.ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, LeetCode.ListNode next) { this.val = val; this.next = next; }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        LeetCode.ListNode p = this;
        while(p!=null){
            sb.append(p.val);
            sb.append(',');
            p = p.next;
        }
        return sb.toString();
    }
}
