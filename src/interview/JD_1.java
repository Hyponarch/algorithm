package interview;

import java.util.*;

/**

 3 3 3 2
 ..S
 *..
 .#.

 #**
 ***
 ###

 *.*
 ##E
 ...

 */
public class JD_1 {
    static int ans = Integer.MAX_VALUE;
    static int[][] directions = new int[][]{new int[]{1, 0, 0}, new int[]{0, 1, 0}, new int[]{0, 0, 1}
        , new int[]{-1, 0, 0},new int[]{0, -1, 0}, new int[]{0, 0, -1}};
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int x = sc.nextInt();   //行
        int y = sc.nextInt();   //列
        int z = sc.nextInt();   //层
        int n = sc.nextInt();   //血量
        sc.nextLine();
        char[][][] nums = new char[z][x][y];  //z层，x行，y列
        int[] position = new int[3];
        for(int i = 0; i < z; i++){
            for(int j = 0; j < x; j++){
                String line = sc.nextLine();
                char[] chars = line.toCharArray();
                int p = 0;
                for(int k = 0; k < chars.length; k++){
                    if(chars[k] != ' '){
                        nums[i][j][p] = chars[k];
                        if(chars[k] == 'S'){
                            position = new int[]{i, j, p};
                        }
                        p++;
                    }
                }
            }
            if(i != z - 1)
                sc.nextLine();
        }
        boolean[][][] vis = new boolean[x][y][z];
        Set<int[]> path = new HashSet<>();
        dfs(nums, vis, path, position, n);
        System.out.println(ans - 1);

    }
    static void dfs(char[][][] nums, boolean[][][] vis, Set<int[]> path, int[] position, int n){
        int z = position[0];
        int x = position[1];
        int y = position[2];
        char currPos = nums[z][x][y];
        path.add(position);
        vis[z][x][y] = true;
        if(currPos == 'E'){
            ans = Math.min(ans, path.size());
            return;
        }
        if(nums[x][y][z] == '*'){
            n--;
        }
        if(n < 0){
            return;
        }
        if(path.size() > nums.length + nums[0].length + nums[0][0].length){
            return;
        }
        for(int[] i : directions){
            int newZ = z + i[0];
            int newX = x + i[1];
            int newY = y + i[2];
            if(newZ >= 0 && newZ < nums.length
                    && newX >= 0 && newX < nums[0].length
                    && newY >=0 && newY < nums[0][0].length
                    && !vis[newZ][newX][newY]
                    && nums[newZ][newX][newY] != '#'){
                int[] newPos = new int[]{newZ, newX, newY};
                dfs(nums, vis, path, newPos, n);
                vis[newX][newY][newZ] = false;
                path.remove(newPos);
            }
        }
    }
}
