package cn.goodman.codility;

/**
 * Created by Shaun on 2017/3/14.
 */
public class PermMissingElem {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int L = A.length;
        int[] B = new int[L+1];
        for(int i=0; i<L; i++) {
            int t = A[i];
            B[t-1] = t;
        }
        for(int j=0; j<L; j++) {
            if(B[j] == 0) {
                return j+1;
            }
        }
        return 0;
    }
}
