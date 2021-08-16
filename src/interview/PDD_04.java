package interview;

import java.util.*;

//10进制阶乘，每个因子5之间，至少有一个偶数，偶数*5 = 10，贡献一个0
//一个数贡献2个因子5是从25开始，而22-24可以贡献1+3=4个2
//125前面的122-124，可知，2总是过剩的，每一个因子5对应一个0
//对于N在M进制下，如果N % M == 0，则对应一个0
//质数的乘积足以让结果溢出了，对于非M的因子的质数，应当去除

//求质因数列表，从2开始遍历到根号n，对每个数循环求，得到每个质因数的量
//求每个质因数的量，用map保存，leetcode_172，然后对每个质因数求总量除以上式的商，这些商求最小值
public class PDD_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> pri = prime(m);
        //N阶乘中包含的等同于M的因子数
        long count = 0;
        long num = 1;
        for(int i = 1; i <= n; i++){
            boolean flag = true;
            for(int p : pri){
                if(i % p == 0){
                    flag =false;
                    break;
                }
            }
            if(flag){
                break;
            }
            int curr = i;
            while(curr > 0 && curr % m ==0){
                count++;
                curr /= m;
            }
            num *= curr;
            while(num >0 && num % m == 0){
                count++;
                num /= m;
            }
        }
        System.out.println(count);
    }

    //求质数
    static Set<Integer> prime(int m){
        Set<Integer> ans = new HashSet<>();
        for(int i = 0; i < m; i++){
            if(isPrime(i)){
                ans.add(i);
            }
        }
        return ans;
    }
    static boolean isPrime(int m){
        for(int i = 2; i * i < m; i++){
            if(m % i == 0){
                return false;
            }
        }
        return true;
    }
}
