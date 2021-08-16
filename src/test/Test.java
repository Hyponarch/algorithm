package test;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    class OverrideHashCode{


        int val;
        public OverrideHashCode(int val){
            this.val = val;
        }
        //只要重写equals和hashCode方法，就可以实现HashSet，HashMap contains方法的自定义比较
        @Override
        public int hashCode(){
            return val;
        }
        @Override
        public boolean equals(Object obj){
            //是该对象本身
            if(obj == this){
                return true;
            }
            //不是该类的对象，无法比较
            if(!(obj instanceof OverrideHashCode)){
                return false;
            }
            //认为值相等就相等
            return this.val == ((OverrideHashCode)obj).val;
        }
    }
    public static void main(String[] args) {

        int half = (int)1e9 + 5;
        int divisor = (int)1e9 + 7;
        int res = half * (half % divisor);

        System.out.println(half * half % divisor);
        System.out.println((half % divisor) * (half % divisor));
        System.out.println((half % divisor * half % divisor) % divisor);

        long longRes = ((long)half * (long)half) % divisor;
        System.out.println(longRes);

        Integer.bitCount(1);
        List<Integer> lis = new ArrayList<>();
        lis.add(1);
        List<Integer> lis1 = new ArrayList<>();
        lis1.add(1);
        System.out.println(lis.equals(lis1));

        List<int[]> lis2 = new ArrayList<>();
        lis2.add(new int[]{1});
        List<int[]> lis3 = new ArrayList<>();
        lis3.add(new int[]{1});
        System.out.println(lis2.equals(lis3));

        Set<OverrideHashCode> sohs = new HashSet<>();
        Test t = new Test();
        OverrideHashCode o1 = t.new OverrideHashCode(1);
        OverrideHashCode o2 = t.new OverrideHashCode(1);
        sohs.add(o1);
        System.out.println(sohs.contains(o2));



        //ListIterator允许遍历时修改、添加、删除元素，且只遍历原本的元素
        List<Integer> li = new ArrayList<>(List.of(1,2,3,4));
        Collections.sort(li);
        ListIterator<Integer> it = li.listIterator();
        while (it.hasNext()){
            if(it.next() % 2 == 0){
                it.add(0);
            }
        }
        System.out.println(li.toString());
        StringBuilder sb = new StringBuilder();
        Math.pow(1, 2);
        System.out.println(3.0 % 2);
        BigInteger a1 = new BigInteger("1");
        a1.pow(2).mod(new BigInteger("1"));
        new String(1+"");
        System.out.println(Long.MAX_VALUE / 1e9);

//        Integer.parseInt();
//        Arrays.copyOf
//        sb.dele
//        PriorityQueue<Integer> s = new PriorityQueue<>();
//        s.
//        Solution s = new Solution();
//        for(String str : s.restoreIpAddresses("101023")){
//            System.out.println(str);
//        }
        Queue<Integer> q = new LinkedList<>();
//        q.
        Set<Integer> s = new HashSet<>();
        s.add(1);
        s.add(2);
        List<Integer> ls = new ArrayList(s);
        s.add(3);
        System.out.println(ls.toString());
        List<ArrayList<Integer>> lLI = new ArrayList<ArrayList<Integer>>();
//        lLI.add(List.of(1, 2, 3));
//        new ArrayList<>().
        System.out.println(0.0 == 0);
        Integer[] a = new Integer[]{1,2,3};
        int b = a[0];
        b++;
        System.out.println(a[0]);
        Integer c = a[0];
        c++;
        Integer zero = Integer.valueOf(0);

        Integer addr = Integer.MAX_VALUE;
        Integer addr1 = Integer.MAX_VALUE;
        System.out.println(addr == addr1);
        Integer addr2 = addr;
        System.out.println(addr == addr2);
        addr2--;
        System.out.println(addr);
        System.out.println(addr == addr2);

        List<Integer> l = new ArrayList<>(Arrays.asList(Integer.valueOf(10000000), Integer.valueOf(10000001), Integer.valueOf(10000002)));
        Integer d = l.get(0);
//        (l.get(0))++;
        System.out.println(d.hashCode());
        d += 1;
        System.out.println(d.hashCode());
        System.out.println(d);
        System.out.println(d.getClass().getSimpleName());
        System.out.println(l.toString());

        List<Obj> objList = new ArrayList<>(Arrays.asList(new Obj(0), new Obj(1), new Obj(2)));
        Obj o = objList.get(0);
        o.num++;
        System.out.println(o == objList.get(0));
        System.out.println(o.num);
        System.out.println(objList.toString());

        Obj[] objArray = new Obj[]{new Obj(0), new Obj(1), new Obj(2)};
        Obj objArray0 = objArray[0];
        objArray0.num++;
        System.out.println(Arrays.toString(objArray));




        int i = 2;
        int mm = --i;
        int j = 2;
        int nn = j--;
        int k = 2;
        int cal = 1 + k--;
        int cal1 = 1 + (--k);
        System.out.println(mm);
        System.out.println(i);
        System.out.println(nn);
        System.out.println(j);
        System.out.println(cal);
        System.out.println(cal1);
//        for (int j = 0; j < 5 && j != i; j++) {
//            System.out.println(j);
//        }
//        System.out.println((-5) / 2);
//        System.out.println((-5) % 2);
//        System.out.println((-5) % (-2));
//        System.out.println((-5) / (-2));
//        System.out.println((5) / (-2));
//        System.out.println(5 % (-2));
    }

}
class Obj{
    int num;
    public Obj(int num){
        this.num = num;
    }
    @Override
    public String toString(){
        return this.num+"";
    }
}
//class Solution {
//    public List<String> restoreIpAddresses(String s) {
//        List<String> ans = new ArrayList<String>();
//
//        if(s.length()<4 || s.length()>12){
//            return  ans;
//        }
//        StringBuffer path = new StringBuffer();
//        //回溯算法
//        dfs(s, path, ans, 0);
//        return ans;
//    }
//    void dfs(String s, StringBuffer path, List<String> ans, int num){
//        if(num==4 && path.length() != s.length()+4){
//            return;
//        }
//        if(num==4 && path.length() == s.length()+4){
//            //去掉末尾的.
//            ans.add(path.substring(0, path.length()-1));
//            return;
//        }
//        int start = path.length() - num;
//
//        //只能取一个0
//        if(s.charAt(start)=='0'){
//            //访问s是不包含.的，所以需要-num
//            path.append(s.charAt(start));
//
//            path.append('.');
//
//            dfs(s, path, ans,num+1);
//            //delete含起点，不含终点，删除了start+num和start+1+num，访问path是带.的，所以需要加回来
//            path.delete(start+num, start+num+2);
//        }else{
//            //该次取的数字长度
//            for(int j=1;j<=3;j++){
//                int remainLen = s.length() - path.length() + num - j;
//                if(remainLen < 0){
//                    continue;
//                }
//                String part = s.substring(start, start+j);
//
//                int remainPart = 3 - num;
//                if( remainLen > 3 * remainPart || remainLen < remainPart){
//                    continue;
//                }
//                if(j==3){
//                    int partInt = Integer.parseInt(part);
//                    if(partInt>255){
//                        continue;
//                    }
//                }
//                path.append(part);
//                path.append('.');
//
//                dfs(s, path, ans, num+1);
//                //访问path是带.的，所以需要加回来
//                path.delete(start+num, start+num+1+j);
//
//            }
//        }
//
//    }
//    int MAX_WEIGHT = Integer.MAX_VALUE;
//    public void floyd(int[][] matrix, int[][] pathMatrix, int[][] preTable){
//        //路径矩阵（D），表示顶点到顶点的最短路径权值之和的矩阵，初始时，就是图的邻接矩阵。
//        pathMatrix = new int[matrix.length][matrix.length];
//        //前驱表（P），P[m][n] 的值为 m到n的最短路径的前驱顶点，如果是直连，值为n。也就是初始值
//        preTable = new int[matrix.length][matrix.length];
//
//        //初始化D,P
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix.length; j++) {
//                pathMatrix[i][j] = matrix[i][j];
//                preTable[i][j] = j;
//            }
//        }
//
//        //循环 中间经过顶点
//        for (int k = 0; k < matrix.length; k++) {
//            //循环所有路径
//            for (int m = 0; m < matrix.length; m++) {
//
//                for (int n = 0; n < matrix.length; n++) {
//
//                    int mn = pathMatrix[m][n];
//                    int mk = pathMatrix[m][k];
//                    int kn = pathMatrix[k][n];
//                    int addedPath = (mk == MAX_WEIGHT || kn == MAX_WEIGHT)? MAX_WEIGHT : mk + kn;
//
//                    if (mn > addedPath) {
//                        //如果经过k顶点路径比原两点路径更短，将两点间权值设为更小的一个
//                        pathMatrix[m][n] = addedPath;
//                        //前驱设置为经过下标为k的顶点
//                        preTable[m][n] = preTable[m][k];
//                    }
//
//                }
//            }
//        }
//    }
//
//}