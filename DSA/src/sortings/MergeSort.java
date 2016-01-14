/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

/**
 *
 * @author stoilov
 */
public class MergeSort {

    public static void sort(int[] arr) {
        sortArray(arr, 0, arr.length - 1);
    }

    private static void sortArray(int[] arr, int left, int right) {
        if ((right - left) < 1) {
            return;
        }

        int middle1 = (left + right) / 2;
        int middle2 = middle1 + 1;

        sortArray(arr, left, middle1);
        sortArray(arr, middle2, right);

        merge(arr, left, middle1, middle2, right);
    }

    private static void merge(int[] arr, int left, int middle1, int middle2, int right) {
        int leftIndex = left;
        int rightIndex = middle2;
        int commonIndex = left;
        int[] common = new int[arr.length];

        while (leftIndex <= middle1 && rightIndex <= right) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                common[commonIndex++] = arr[leftIndex++];
            } else {
                common[commonIndex++] = arr[rightIndex++];
            }
        }

        if (leftIndex == middle2) {
            while (rightIndex <= right) {
                common[commonIndex++] = arr[rightIndex++];
            }
        } else {
            while (leftIndex <= middle1) {
                common[commonIndex++] = arr[leftIndex++];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = common[i];
        }
    }

}
