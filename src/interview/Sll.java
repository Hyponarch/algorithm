package interview;

import java.util.*;

public class Sll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int max = (int)1e9 + 7;
        int len = str.length();
        int countA = 0;
        long countB = 0;
        long ans = 0;
        for(int i = len - 1; i >= 0; i--){
            if(str.charAt(i) == 'b'){
                countB++;
            }else {
                countA++;
                ans += countB;
                ans %= max;
                countB *= 2;
                countB %= max;
            }
        }
        ans %= max;
        System.out.println(ans);
    }
}
