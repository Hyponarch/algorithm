package interview;

import java.util.*;

//字典序的前一个排列
public class PDD_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        char[] c = sc.nextLine().toCharArray();
        //当前的c不满足
        boolean exist = true;
        while(!isStrange(c, k)){
            //则找上一个排列
            if(!lastPerm(c)){
                //如果上一个排列不存在，则输出-1
                System.out.println(-1);
                exist = false;
                break;
            }
        }
        if(exist){
            System.out.println(Arrays.toString(c));
        }


//        if(isStrange(c, k)){
//            System.out.println(Arrays.toString(c));
//        }else {
//            boolean res = lastPerm(c);
//            if(!res){
//                System.out.println(-1);
//            }else {
//                while(!isStrange(c, k)){
//                    if(!lastPerm(c)){
//                        System.out.println(-1);
//                    }
//                }
//                System.out.println(Arrays.toString(c));
//            }
//        }

    }
    static boolean lastPerm(char[] c){
        //从右往左找第一个递减的二元组的前者
        int l = -1;
        for(int i = c.length - 1; i > 0; i--){
            if(c[i] < c[i-1]){
                l = i - 1;
                break;
            }
        }
        //如果找不到，则没有
        if(l == -1){
            return false;
        }
        int r = 0;
        //从右往左找到第一个小于c[l]的字符
        for(int i = c.length - 1; i > l; i--){
            if(c[i] < c[l]){
                r = i;
                break;
            }
        }
        //交换r和l
        char tmp = c[l];
        c[l] = c[r];
        c[r] = tmp;
        //将l以后的数按降序排列
        //交换后的伙伴段是升序的
        int left = l + 1;
        int right = c.length - 1;
        while(right < left){
            char tmpChar = c[left];
            c[left] = c[right];
            c[right] = tmpChar;
        }
        return true;
    }
    static boolean isStrange(char[] c, int k){
        int[] freq = new int[26];
        for(char ch : c){
            freq[ch - 'a']++;
        }
        for(int i : freq){
            if(i != 0 && i % k != 0){
                return false;
            }
        }
        return true;
    }
}
