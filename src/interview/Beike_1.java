package interview;

import java.util.*;

public class Beike_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < n; i++){
           int num = sc.nextInt();
           int f = freq.getOrDefault(num, 0);
           freq.put(num, f+1);
        }
        int ans = 0;
        for(Integer i : freq.values()){
            ans = Math.max(ans, i);
        }
        System.out.println(ans);

    }
}
