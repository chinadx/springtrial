package cn.goodman.codility;

/**
 * Created by Shaun on 2017/3/14.
 */
public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int N = A.length;
        /**
         * if K > N, there is a circle.
         */
        K = K % N;
        if(K == 0) {
            return A;
        }
        int[] B = new int[N];
        int begin = N - K;
        int j = 0;
        for(int i = begin; i < N; i++) {
            B[j++] = A[i];
        }
        int x = 0;
        for(;j < N; j++) {
            B[j] = A[x++];
        }
        return B;
    }
}
