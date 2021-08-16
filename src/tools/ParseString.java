package tools;

import java.util.Arrays;

public class ParseString {
    public static int[][] stringToArrArr(String str){
        int len = str.length();
        String[] strArr = str.substring(2, len - 2).split("],\\[");
        int m = strArr.length;
        int n = strArr[0].split(",").length;
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++){
            res[i] = Arrays.stream(strArr[i].split(",")).mapToInt(Integer::parseInt).toArray();
        }
        return res;
    }
    public static char[][] stringToCharArrArr(String str){
        int len = str.length();
        String[] strArr = str.substring(2, len - 2).replace("'", "").split("],\\[");
        int m = strArr.length;
        int n = strArr[0].split(",").length;
        char[][] res = new char[m][n];
        for(int i = 0; i < m; i++){
            res[i] = strArr[i].replace(",", "").toCharArray();
        }
        return res;
    }
}
