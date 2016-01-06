/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author stoilov
 */
public class QuickSort {

    private static final Random random = new Random();

    public static void insertionSort(int[] arr) {
        int insert;

        for (int i = 0; i < arr.length; i++) {
            insert = arr[i];

            int moveItem = i;

            while (moveItem > 0 && arr[moveItem - 1] > insert) {
                arr[moveItem] = arr[moveItem - 1];
                moveItem--;
            }

            arr[moveItem] = insert;
        }
    }

    public static void selectionSort(int[] arr) {
        int smallest;

        for (int i = 0; i < arr.length; i++) {
            smallest = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[smallest] > arr[j]) {
                    smallest = j;
                }
            }

            if (smallest != i) {
                swap(arr, i, smallest);
            }
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (arr == null || left >= right) {
            return;
        }

        int current = partition(arr, left, right);
        quickSort(arr, left, current);
        quickSort(arr, current + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        if (arr == null) {
            return -1;
        }

        int i = left;
        int j = right;

//        int pivot = random.nextInt(arr.length);
        int pivot = arr[i];

        do {

            while (pivot >= arr[i]) {
                i++;
            }

            while (pivot < arr[j]) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }

        } while (i <= j);

        return j;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 7, 5, 6, 2, 1};

//        insertionSort(arr);
//        selectionSort(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
