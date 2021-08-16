package interview;

import java.util.*;

/**
 * sougou
 * 给一个由数字组成的字符串。求出其可能恢复为的所有IP地址。
 * (你的任务就是往这段字符串中添加三个点, 使它成为一个合法的IP地址. 返回所有可能的IP地址.)
 * sougou
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * 解释: ["255.255.111.35", "255.255.11.135"] 同样可以.
 */
public class Sougou {
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        String input = "25525511135";
        dfs(input, 0, ans, path, 0);
        System.out.println(ans.toString());
    }
     static void dfs(String str, int idx, List<String> ans, StringBuilder path, int part){
         int len = str.length();
        //每分一段加入一点.
         if(part == 4){
             if(len + 4 == path.length()){
                 //这里不能改动path
//            ans.add(path.deleteCharAt(path.length() - 1).toString());
                 ans.add(path.substring(0, path.length() - 1));
             }
             //return应该在外面
             return;
         }

        //剩余长度不符合要求
        if(len - idx < 4 - part || len - idx > 3 * (4 - part)){
            return;
        }

        //0不能作为开头
        if(str.charAt(idx) == '0'){
            path.append(0 + ".");
            dfs(str, idx + 1, ans, path, part + 1);
            path.delete(path.length() - 2, path.length());
        }else {
            //取的长度
            for(int i = 1; i < 4 && idx + i <= len; i++){
                String s = str.substring(idx, idx + i);
                if(isLegal(s)){
                    path.append(s).append(".");
                    dfs(str, idx + i, ans, path, part + 1);
//                    path.delete(path.length() - s.length() - 1, path.length());
                    path.delete(idx + part, path.length());
                }
            }
        }

    }
    static boolean isLegal(String s){
        int i = Integer.parseInt(s);
        return  i >= 0 && i <= 255;
    }
}
