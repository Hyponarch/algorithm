package LeetCode;
import java.util.*;

/**
 * @author luchenl.chen
 * email: luchenl.chen@qunar.com
 * create date: 2022/4/21 11:27
 * @version : 1.0
 * description:
 * 给你一个由若干单词组成的句子 sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
 *
 * 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
 *
 * 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
 * 例如，单词 "apple" 变为 "applema" 。
 * 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词 "goat" 变为 "oatgma" 。
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 * 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
 * 返回将 sentence 转换为山羊拉丁文后的句子。
 *
 */
public class Problem_824 {
    class Solution {
        public String toGoatLatin(String sentence) {
            String[] words = sentence.split(" ");
            Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
            StringBuffer answer = new StringBuffer();
            for(int i = 0; i < words.length; i++) {
                String curr = words[i];
                StringBuffer res = new StringBuffer();
                if(!vowel.contains(curr.charAt(0))){
                    res.append(curr.substring(1, curr.length())).append(curr.charAt(0));
                }else {
                    res.append(curr.substring(0, curr.length()));
                }
                res.append("ma");
                for(int j = 0; j < i + 1; j++){
                    res.append('a');
                }
                answer.append(res);
                if(i != words.length - 1){
                    answer.append(" ");
                }
            }
            return answer.toString();
        }
    }
}
