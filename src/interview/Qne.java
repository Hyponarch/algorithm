package interview;

import java.util.*;

public class Qne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Map<Integer, Integer> freqs = new HashMap<>();
        for(int i : array){
            int freq = freqs.getOrDefault(i, 0);
            freqs.put(i, freq + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for(Map.Entry<Integer, Integer> entry : freqs.entrySet()){
            if(heap.size() < k){
                heap.add(entry);
            }else {
                if(entry.getValue() > heap.peek().getValue()){
                    heap.poll();
                    heap.offer(entry);
                }
            }
        }
        System.out.println(heap.peek().getKey());
    }
}
