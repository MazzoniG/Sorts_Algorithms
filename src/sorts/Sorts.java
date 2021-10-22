package sorts;

import java.util.*;

/**
 * @author Guillermo E. Mazzoni Algorithms Analyze
 */
public class Sorts {

    //Bubble Sort
    public static void BubbleSort(int[] num) {
        int j;
        boolean flag = true;
        int temp;

        while (flag) {
            flag = false;
            for (j = 0; j < num.length - 1; j++) {
                if (num[ j] < num[j + 1]) {
                    temp = num[ j];
                    num[ j] = num[ j + 1];
                    num[ j + 1] = temp;
                    flag = true;
                }
            }
        }
    }

    //Insertion Sort
    public static void InsertionSort(int[] num) {
        int j;
        int key;
        int i;

        for (j = 1; j < num.length; j++) {
            key = num[ j];
            for (i = j - 1; (i >= 0) && (num[ i] < key); i--) {
                num[ i + 1] = num[ i];
            }
            num[ i + 1] = key;
        }
    }

    //Selection Sort
    public static void SelectionSort(int[] num) {
        int i, j, first, temp;
        for (i = num.length - 1; i > 0; i--) {
            first = 0;
            for (j = 1; j <= i; j++) {
                if (num[ j] < num[ first]) {
                    first = j;
                }
            }
            temp = num[ first];
            num[ first] = num[ i];
            num[ i] = temp;
        }
    }

    // Merge Sort Begins
    public static void MergeSort(int[] array) {
        if (array.length > 1) {

            int[] left = leftHalf(array);
            int[] right = rightHalf(array);

            MergeSort(left);
            MergeSort(right);

            merge(array, left, right);
        }
    }

    public static int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }

    public static int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }

    public static void merge(int[] result,
            int[] left, int[] right) {
        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length
                    && left[i1] <= right[i2])) {
                result[i] = left[i1];
                i1++;
            } else {
                result[i] = right[i2];
                i2++;
            }
        }
    }
    //Merge Sort Ends

    //Radix Sort
    public static int[] RadixSort(int[] old) {

        for (int shift = Integer.SIZE - 1; shift > -1; shift--) {

            int[] tmp = new int[old.length];
            int j = 0;

            for (int i = 0; i < old.length; i++) {
                boolean move = old[i] << shift >= 0;
                if (shift == 0 ? !move : move) {
                    tmp[j] = old[i];
                    j++;
                } else {
                    old[i - j] = old[i];
                }
            }
            for (int i = j; i < tmp.length; i++) {
                tmp[i] = old[i - j];
            }
            old = tmp;
        }
        return old;
    }

    //Quick Sort. My implementation, without using extra  memory.
    public static int[] QuickSort(int[] array) {

        int i = 0;
        while (i < array.length - 1) {

            for (int d = array.length - 1; d >= 0; d--) {

                if (i == d) {
                    i++;
                    d = array.length - 1;

                    if (i == array.length - 1) {
                        break;
                    }
                }

                if (array[d] < array[i]) {
                    int temp = array[i];
                    array[i] = array[d];
                    array[d] = temp;
                    d = array.length - 1;
                }
            }
        }
        return array;
    }
    
    //Heap Sort. My implementation, without using extra  memory.
    public static int[] HeapSort(int array[]) {
        int c = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (i == 0) {
                if (c == 0) {
                    break;
                } else {
                    i = array.length - 1;
                    c = 0;
                }
            }

            if (i % 2 == 0 || i == 0) {
                if (array[i] < array[(i - 2) / 2]) {
                    int temp = array[(i - 2) / 2];
                    array[(i - 2) / 2] = array[i];
                    array[i] = temp;
                    c++;
                }
            } else {
                if (array[i] < array[(i - 1) / 2]) {
                    int temp = array[(i - 1) / 2];
                    array[(i - 1) / 2] = array[i];
                    array[i] = temp;
                    c++;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {

        Integer A[] = new Integer[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }

        Collections.shuffle(Arrays.asList(A));

        int B[] = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i];
        }
      
        HeapSort(B);
    }
}
