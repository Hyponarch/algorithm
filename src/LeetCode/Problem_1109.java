package LeetCode;

public class Problem_1109 {

    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] ans = new int[n];
            for(int i = 0; i < bookings.length; i++){
                for(int j = bookings[i][0] - 1; j <= bookings[i][1] - 1; j++){
                    ans[j] += bookings[i][2];
                }
            }
            return ans;
        }

        public int[] corpFlightBookings1(int[][] bookings, int n) {
            //差分数组
            int[] ans = new int[n];
            for(int i = 0; i < bookings.length; i++){
                ans[bookings[i][0] - 1] += bookings[i][2];
                if(bookings[i][1] < n){
                    ans[bookings[i][1] - 1] -= bookings[i][2];
                }
            }
            for(int i = 1; i < n; i++){
                ans[i] += ans[i-1];
            }
            return ans;
        }
    }
}
