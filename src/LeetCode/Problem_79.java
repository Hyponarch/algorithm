package LeetCode;

public class Problem_79 {

    public static void main(String[] args) {
        Solution s = new Problem_79().new Solution();
        System.out.println(s.exist(new char[][]{new char[]{'A','B','C','E'},new char[]{'S','F','E','S'},new char[]{'A','D','E','E'}},
        "ABCESEEEFS"));
    }

    class Solution {
        int[][] directions = new int[][]{new int[]{1, 0}, new int[]{0, 1},
                new int[]{-1, 0}, new int[]{0, -1}};
        public boolean exist(char[][] board, String word) {
            //根据字符频数剪枝
            int range = 'z' - 'A';
            int[] wordFreq = new int[range];
            int[] boardFreq = new int[range];
            for(int i = 0; i < word.length(); i++){
                wordFreq[word.charAt(i) - 'A']++;
            }
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    boardFreq[board[i][j] - 'A']++;
                }
            }
            for(int i = 0; i < wordFreq.length; i++){
                if(boardFreq[i] < wordFreq[i]){
                    return false;
                }
            }

            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    boolean[][] vis = new boolean[board.length][board[0].length];
                    if(board[i][j] == word.charAt(0)){
                        if(dfs(board, word, vis, 0, i, j)){
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        boolean dfs(char[][] board, String word, boolean[][] vis, int idx, int x, int y){
            vis[x][y] = true;
            // if(board[x][y] != word.charAt(idx)){
            //     return false;
            // }
            if(idx == word.length() - 1){
                return true;
            }
            for(int[] direction : directions){
                int newX = x + direction[0];
                int newY = y + direction[1];
                if(newX >= 0 && newX < board.length
                        && newY >= 0 && newY < board[0].length
                        && !vis[newX][newY]
                        && board[newX][newY] == word.charAt(idx + 1)){
                    if(dfs(board, word, vis, idx + 1, newX, newY)){
                        return true;
                    }
                }
            }
            vis[x][y] = false;
            return false;
        }
    }
}
