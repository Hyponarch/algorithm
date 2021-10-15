package jz_offer;

/**
 * @author luchenl.chen
 * @date 2021/10/14 14:10
 */
public class JZ_2_069 {
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            //二分法找到最左的大于右侧数的数字的下标
            int left = 0;
            int right = arr.length;
            while (left < right){
                int mid = left + (right - left) / 2;
                //当中点比右侧的数大时，那么山峰下标 <= mid
                if(arr[mid] > arr[mid + 1]){
                    right = mid;
                }else { //当终点比右侧数下时，山峰下标 > mid
                    left = mid + 1;
                }
            }
            return left;
        }
    }

}
