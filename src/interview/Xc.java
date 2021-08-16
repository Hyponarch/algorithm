package interview;

import java.util.*;

public class Xc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[n];
        long[] prefixSum = new long[n + 1];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        //prefixSum[j + 1] - prefixSum[i])% m == 0
        //即prefixSum[j + 1] % m == prefixSum[i] % m
        //用HashMap,以余数作为key，以数量作为value，则符合条件的下标对数为组合数C(n, 2)

        //使用数组作为哈希表
        System.out.println(arrayAsHash(nums, m, prefixSum));
        //使用HashMap
//        System.out.println(hashMap(nums, m, prefixSum));

    }
    //使用数组作为哈希表
    static int arrayAsHash(int[] nums, int m, long[] prefixSum){
        int n = nums.length;
        int[] freq = new int[10000];
        int count = 0;
        prefixSum[0] = 0;
        for(int i = 1; i < n + 1; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            //如果某些前缀和的余数相同，则这些数两两组合的区间和，也可以被m整除
            int remainder = (int)Math.abs(prefixSum[i] % m);
            freq[remainder]++;
            //如果数字本身能被m整除，则算一个
            if(prefixSum[i] % m == 0){
                count++;
            }
        }
        for(int i = 0; i < 10000; i++){
            if(freq[i] != 0){
                count += freq[i] * (freq[i] - 1) / 2;
            }
        }
        return count;
    }
    //使用HashMap
    static int hashMap(int[] nums, int m, long[] prefixSum){
        int n = nums.length;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;
        prefixSum[0] = 0;
        for(int i = 1; i < n + 1; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            //如果某些前缀和的余数相同，则这些数两两组合的区间和，也可以被m整除
            int remainder = (int)Math.abs(prefixSum[i] % m);
            int f = freqMap.getOrDefault(remainder, 0);
            freqMap.put(remainder, f + 1);
            //如果数字本身能被m整除，则算一个
            if(prefixSum[i] % m == 0){
                count++;
            }
        }
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            count += entry.getValue() * (entry.getValue() - 1) / 2;
        }
        return count;
    }
}
