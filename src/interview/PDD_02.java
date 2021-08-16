package interview;

import java.util.*;

public class PDD_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n < 10){
            System.out.println(n);
        }else{
            int fac = 1;
            while(!isHappy(fac * n)){
                fac++;
            }
            System.out.println(fac * n);
        }
    }
    static boolean isHappy(int a){
        Set<Integer> set = new HashSet<>();
        while(a > 0){
            int tmp = a % 10;
            if(tmp > 1){
                set.add(a % 10);
            }
            a /= 10;
        }
        return set.size() <= 1;
    }
}
