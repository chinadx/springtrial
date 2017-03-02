package cn.goodman.algorithm;

/**
 * Created by Shaun on 2017/3/2.
 */
public class Searches {

    public static int splitHalf(int[] arrayData, int searchData, int start, int end) {
        int index = (start + end) / 2;
        int data = arrayData[index];
        if (start > end) {
            return -1;
        }
        if (data == searchData) {
            return index;
        } else {
            if (data < searchData) {
                return splitHalf(arrayData, searchData, index + 1, end);
            } else {
                return splitHalf(arrayData, searchData, start, index - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 12, 23, 26, 31, 36, 37, 44, 81, 91, 93, 95, 102, 104};
        System.out.println(sortedArray.length);
        int idx = splitHalf(sortedArray, 37, 0, sortedArray.length - 1);
        System.out.print(idx);
    }
}
