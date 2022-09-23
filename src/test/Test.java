package test;

import java.util.Arrays;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        HashSet<String> stringSet = new HashSet<>();
        stringSet.add("1,2");
        stringSet.add("2,3");
        System.out.println(stringSet.contains("1,2"));
        HashSet<int[]> set = new HashSet<>();
        set.add(new int[]{1, 2});
        set.add(new int[]{3, 4});
        System.out.println(set.contains(new int[]{1, 2}));
        System.out.println(set.contains(new int[]{2, 1}));
        System.out.println(Arrays.equals(new int[]{1, 2}, new int[]{1, 2}));
        System.out.println();
        String s = null + "";
        System.out.println(s == null);
        System.out.println(null + "");

        StringBuilder sb1 = new StringBuilder();

        String nullStr = null;
        sb1.append("1").append(nullStr);
        System.out.println(sb1);


        String sb = "TIme";
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < sb.length(); i++){
            stringBuffer.append(Character.toLowerCase(sb.charAt(i)));
        }
        System.out.println(stringBuffer);
        int intAns = 1;
        long longAns = 1;
        int curr = 2;
        while (intAns == longAns){
            intAns *= curr;
            longAns *= curr;
            curr++;
        }
        System.out.println(curr);
    }
}
