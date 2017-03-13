package cn.goodman.codility;

/**
 * Created by china on 2017/3/13.
 */
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        long sum = 0;
        for(int i : A) {
            sum += i;
        }
        long sum_tmp = 0;
        int index = 0;
        for(int i : A) {
            sum_tmp += i;
            if(sum_tmp - i == sum - sum_tmp) {
                return index;
            }
            index ++;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
