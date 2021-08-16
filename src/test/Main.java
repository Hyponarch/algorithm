package test;

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            boolean noRes = true;
            for(int i = n; i <= m; i++){
                int sum = 0;
                for(int j = i; j > 0; j /= 10){
                    sum += (int)Math.pow(j % 10, 3);
                }
                if(sum == i){
                    noRes = false;
                    System.out.println(i);
                }
            }
            if(noRes){
                System.out.println("no");
            }
        }
    }
}
