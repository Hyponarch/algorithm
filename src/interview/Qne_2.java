package interview;

import java.util.*;

public class Qne_2 {
    public static void main(String[] args) {
        System.out.println(getAll(11, 3, 7, "123abcd0000"));
    }
    //end - start 位的二进制编码
    static List<String> getAll(int length, int start, int end, String input) {
        char[] chars = input.substring(start, end).toCharArray();
        List<String> ans = new ArrayList<>();
        dfs(chars, new StringBuilder(), ans, 0);
        Collections.sort(ans);
        String prefix = input.substring(0, start);
        String suffix = input.substring(end);
        for(int i = 0; i < ans.size(); i++){
            StringBuilder sb = new StringBuilder(prefix);
            sb.append(ans.get(i)).append(suffix);
            ans.set(i, sb.toString());
        }
        return ans;
    }
    //dfs，按字典序输出全排列
    static void dfs(char[] chars, StringBuilder path, List<String> ans, int idx){
        if(path.length() == chars.length){
            ans.add(path.toString());
            return;
        }
        char upper = Character.toUpperCase(chars[idx]);
        char lower = Character.toLowerCase(chars[idx]);
        path.append(upper);
        dfs(chars, path, ans, idx + 1);
        path.deleteCharAt(path.length() - 1);
        path.append(lower);
        dfs(chars, path, ans, idx + 1);
        path.deleteCharAt(path.length() - 1);

    }

    /*
    static List<String> getAll(int length, int start, int end, String input) {
        List<String> ans = new ArrayList<>();
        char[] charsSingle = input.substring(start, end).toCharArray();
        char[] chars = new char[charsSingle.length * 2];
        int p = 0;
        for(char c : charsSingle){
            if(Character.isLowerCase(c)){
                chars[p++] = Character.toUpperCase(c);
            }else {
                chars[p++] = Character.toLowerCase(c);
            }
            chars[p++] = c;
        }
        Arrays.sort(chars);
        dfs(chars, new StringBuilder(), ans, new boolean[chars.length], end - start);
        String prefix = input.substring(0, start);
        String suffix = input.substring(end);
        for(int i = 0; i < ans.size(); i++){
            StringBuilder sb = new StringBuilder(prefix);
            sb.append(ans.get(i)).append(suffix);
            ans.set(i, sb.toString());
        }
        return ans;
    }
    //dfs，按字典序输出全排列
    static void dfs(char[] chars, StringBuilder path, List<String> ans, boolean[] vis, int len){
        if(path.length() == len){
            ans.add(path.toString());
            return;
        }
        for(int i = 0; i < chars.length; i++){
            //当前位置的字符未使用
            if(!vis[i]){
                //当前字符与前一个字符相同，且前一个字符未使用
                if(i != 0 && chars[i] == chars[i-1] && !vis[i-1]){
                    continue;
                }
                path.append(chars[i]);
                vis[i] = true;
                dfs(chars, path, ans, vis, len);
                path.deleteCharAt(path.length() - 1);
                vis[i] = false;
            }
        }
    }
    */

}
