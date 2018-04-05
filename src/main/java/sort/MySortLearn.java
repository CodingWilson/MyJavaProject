package sort;

import java.util.Arrays;

public class MySortLearn {
    public static void swap(Integer[] array, int i, int j) {
        array[i] = array[i] + array[j];
        array[j] = array[i] - array[j];
        array[i] = array[i] - array[j];
    }

    public static void sortBubble(Integer[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void sortChoose(Integer[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }//锁送到
            }
        }
    }

    public static void sortInsert(Integer[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int value = array[i];
            int pre = i - 1;
            while (pre >= 0 && array[pre] > value) {
                swap(array, pre, pre );
                pre --;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{2, 4, 1};
//        sortBubble(array);
//        sortChoose(array);
        sortInsert(array);
        print(array);
    }

    public static void print(Integer[] array) {
        System.out.println(Arrays.deepToString(array));
    }
}
