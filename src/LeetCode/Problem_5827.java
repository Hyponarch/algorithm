package LeetCode;

import javax.swing.plaf.basic.BasicGraphicsUtils;

public class Problem_5827 {
    public static void main(String[] args) {
        Solution s= new Problem_5827().new Solution();
//        char[][] arr = tools.ParseString.stringToCharArrArr("[" +
//                "['.','.','.','B','.','.','.','.']," +
//                "['.','.','.','W','.','.','.','.']," +
//                "['.','.','.','W','.','.','.','.']," +
//                "['.','.','.','W','.','.','.','.']," +
//                "['W','B','B','.','W','W','W','B']," +
//                "['.','.','.','B','.','.','.','.']," +
//                "['.','.','.','B','.','.','.','.']," +
//                "['.','.','.','W','.','.','.','.']]");
        char[][] arr = tools.ParseString.stringToCharArrArr("[" +
                "['.','.','.','.','.','.','.','.']," +
                "['.','B','.','.','W','.','.','.']," +
                "['.','.','W','.','.','.','.','.']," +
                "['.','.','.','W','B','.','.','.']," +
                "['.','.','.','.','.','.','.','.']," +
                "['.','.','.','.','B','W','.','.']," +
                "['.','.','.','.','.','.','W','.']," +
                "['.','.','.','.','.','.','.','B']]");

        System.out.println(s.checkMove(arr, 4,4,'W'));
    }
    class Solution {
        int m;
        int n;
        public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
            //朝着上、下、左、右、左上、右上、左下、右下分别遍历，直到边界
            //如果遇到同色，则第三个如果是同色，满足，否则不满足
            //如果遇到异色，则再遇到同色满足，如果是空格则不满足，如果是异色则继续遍历，如果到了边界依旧没有同色，则不满足
            //合法结构应当为AAA或者AB+A
            //必须作为端点，所以[A][AAA]是不满足的，要同时往两端扩展
            m = board.length;
            n = board[0].length;
            int[][] directs = new int[][]{new int[]{0 ,1}, new int[]{1 ,1}, new int[]{0 ,1},new int[]{-1 ,1},
                    new int[]{-1 ,0},new int[]{-1 ,-1},new int[]{0 ,-1},new int[]{1 ,-1}};
            for(int i = 0; i < directs.length; i++){
                int type = -1;  //0=AAA,1=AB+A
                int newR = rMove;
                int newC = cMove;
                while (true){
                    newR += directs[i][0];
                    newC += directs[i][1];
                    if(isValid(newR, newC)){
                        char curr = board[newR][newC];
                        if(curr == '.'){
                            break;
                        }
                        //相邻格子
                        if(Math.abs(newR - rMove) == 1 || Math.abs(newC - cMove) == 1){
                            //颜色相同则为类别0，AAA
                            if(curr == color){
                                type = 0;
                            }else {     //不同则为类别1，AB+A
                                type = 1;
                            }
                        }else { //长度达到3
                            //和起点相同
                            if(curr == color){
                                return true;    //AAA或者AB+A
                            }
                            //类型1，且和前一个格子相同，继续遍历
                            if(type == 1 && curr == board[newR - directs[i][0]][newC - directs[i][1]]){
                                continue;
                            }
                            //长度达到3，且跟起点不等，且不是AB+A类型，肯定不满足
                            break;
                        }

                    }else {
                        break;
                    }
                }
            }
            //走到终点
            return false;
        }
        boolean isValid(int c, int r){
            return (c > -1 && r > -1
                    && c < m && r < n);
        }
    }
}
