package LeetCode;

import java.util.*;

public class Problem_1178 {

    public static void main(String[] args) {
        Solution s = new Problem_1178().new Solution();
        System.out.println(s.findNumOfValidWords(new String[]{"aaaa","asas","able","ability","actt","actor","access"},
            new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"}).toString());
    }

    class Solution {
        public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
            //利用位运算来表示各单词的构成字母
            int[] wordBit = new int[words.length];
            int[] puzzleBit = new int[puzzles.length];
            int[] initial = new int[puzzles.length];
            for(int i = 0; i < words.length; i++){
                int bit = 0;
                for(int j = 0; j < words[i].length(); j++){
                    //将bit的第offset位置为1
                    int offset = words[i].charAt(j) - 'a';
                    bit = bit | (1 << offset);
                }
                wordBit[i] = bit;
            }
            for(int i = 0; i < puzzles.length; i++){
                initial[i] = 1 << (puzzles[i].charAt(0) - 'a');
                int bit = 0;
                for(int j = 0; j < puzzles[i].length(); j++){
                    int offset = puzzles[i].charAt(j) - 'a';
                    bit = bit | (1 << offset);
                }
                puzzleBit[i] = bit;
            }
            int[] ans = new int[puzzles.length];
            for(int i = 0; i < puzzles.length; i++){
                for(int j = 0; j < words.length; j++){
                    //words[j]是否包含puzzles[i]的首字母
                    if((initial[i] & wordBit[j]) != initial[i]){
                        continue;
                    }
                    //异或操作求puzzles[i]与words[j]的字符差异，相同
//                    int diff = puzzleBit[i] ^ wordBit[i];
                    //不同的位如果是puzzleBit[i]为1的位说明是puzzle有而word没有的，反之则不符合要求
                    if((puzzleBit[i] | wordBit[j]) == puzzleBit[i]){
                        ans[i]++;
                    }
                }
            }
            List<Integer> ansList = new ArrayList<>();
            for(int i : ans){
                ansList.add(i);
            }
            return ansList;
        }
    }
}
