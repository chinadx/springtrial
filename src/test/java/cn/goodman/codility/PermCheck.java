package cn.goodman.codility;

/**
 * Created by Shaun on 2017/3/14.
 */
public class PermCheck {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int len = A.length;
        int min = 1000000000;
        int max = 0;
        int[] B = new int[len];
        for(int i=0; i<len; i++) {
            if(A[i] > max) {
                max = A[i];
            }
            if(A[i] < min) {
                min = A[i];
            }
            if(A[i] > len) {
                return 0;
            }
            if(B[A[i]-1] == 1) {
                return 0;
            }
            B[A[i]-1] = 1;
        }
        if(min != 1) {
            return 0;
        }
        if(max != len) {
            return 0;
        }
        return 1;
    }
}
