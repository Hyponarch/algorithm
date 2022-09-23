package LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author luchenl.chen
 * email: luchenl.chen@qunar.com
 * create date: 2022/4/19 11:33
 * @version : 1.0
 * description:
 */
public class Problem_821 {
    class Solution {
        public int[] shortestToChar(String s, char c) {
            int len = s.length();
            int lastIndex = 0;
            int[] shortest = new int[len];
            for(int i = 0; i < len; i++) {
                shortest[i] = Integer.MAX_VALUE;
            }
            //栈
            Deque<Integer> stack = new LinkedList<>();
            //第一遍遍历，逐个入栈比较
            for(int i = 0; i < len; i++) {
                //如果(1)栈为空，(2)当前元素为c，(3)栈顶元素不是c，则入栈
                if(stack.isEmpty() || s.charAt(i) == c || s.charAt(stack.peek()) != c) {
                    stack.push(i);
                    if(s.charAt(i) == c) {
                        shortest[i] = 0;
                    }
                } else {    //如果栈顶元素为c，则差距为i-c的索引
                    shortest[i] = i - stack.peek();
                }
            }
            stack.clear();
            //第二遍遍历，反向入栈
            for(int i = len - 1; i > -1; i--) {
                if(stack.isEmpty() || s.charAt(i) == c || s.charAt(stack.peek()) != c) {
                    stack.push(i);
                    if(s.charAt(i) == c) {
                        shortest[i] = 0;
                    }
                } else {
                    shortest[i] = Math.min(shortest[i], stack.peek() - i);
                }
            }
            //遍历结束后，栈中仍有元素
//            while (!stack.isEmpty()) {
//                int top = stack.pop();
//                if(s.charAt(top) == c) {
//                    lastIndex = top;
//                } else {
//                    shortest[top] = lastIndex - top;
//                }
//            }
            return shortest;
        }
    }
}
