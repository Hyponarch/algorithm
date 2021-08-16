package LeetCode;

import java.util.*;

public class Problem_20 {
    class Solution {
        public boolean isValid(String s) {
            //Stack是由Vector实现的，虽然线程安全，但是效率低，已经弃用了
            //java中的栈一般用Deque双端队列接口，LinkedList实现
            Deque<Character> stack = new LinkedList<>() ;
            //给括号对建立映射关系，简化代码
            Map<Character, Character> pair = new HashMap<>();
            pair.put(')', '(');
            pair.put(']', '[');
            pair.put('}', '{');
            //每一个右括号应当消耗掉它左侧的一个左括号
            //当遍历到右括号时，栈顶必须是相应的左括号，并且将这个左括号出栈，才满足要求
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                //如果是右括号
                if(pair.containsKey(c)){
                    //如果当前栈为空，或者栈顶括号不是相应的左括号，则
                    if(stack.isEmpty() || stack.pop() != pair.get(c)){
                        return false;
                    }
                }else { //如果是左括号，则入栈
                    stack.push(c);
                }
            }
            //如果没有出现“右括号没匹配到左括号”的情况，则要判断左括号是否被消耗完，有残留则false
            return stack.isEmpty();
        }
    }


    class Solution1 {
        public boolean isValid(String s) {
            //简单的思路，计数，右括号不能比左括号多
            //但是会出现([)]的情况
            int[] parenthesisCount = new int[2];
            int[] bracketCount = new int[2];
            int[] braceCount = new int[2];
            for(int i = 0; i < s.length(); i++){
                switch (s.charAt(i)){
                    case '(': parenthesisCount[0]++;
                    break;
                    case '[': bracketCount[0]++;
                    break;
                    case '{': braceCount[0]++;
                    break;
                    case ')': {
                        parenthesisCount[1]++;
                        if(parenthesisCount[1] > parenthesisCount[0]){
                            return false;
                        }
                    }
                    break;
                    case ']':{
                        bracketCount[1]++;
                        if(bracketCount[1] > bracketCount[0]){
                            return false;
                        }
                    }
                    break;
                    case '}':{
                        braceCount[1]++;
                        if(braceCount[1] > braceCount[0]){
                            return false;
                        }
                    }
                    break;
                    default:break;
                }
            }
            return parenthesisCount[0] == parenthesisCount[1]
                    && bracketCount[0] == bracketCount[1]
                    && braceCount[0] == braceCount[1];
        }
    }
}
