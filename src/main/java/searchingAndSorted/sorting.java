package searchingAndSorted;

import java.util.Arrays;

//        | Algorithm      | Best       | Avg        | Worst      | Space    |
//        | -------------- | ---------- | ---------- | ---------- | -------- |
//        | Bubble Sort    | O(n)       | O(n²)      | O(n²)      | O(1)     |
//        | Selection Sort | O(n²)      | O(n²)      | O(n²)      | O(1)     |
//        | Insertion Sort | O(n)       | O(n²)      | O(n²)      | O(1)     |
//        | Merge Sort     | O(n log n) | O(n log n) | O(n log n) | O(n)     |
//        | Quick Sort     | O(n log n) | O(n log n) | O(n²)      | O(log n) |

public class sorting {

    public static void main(String[] args) {

        int[] data = {4, 1, 3, 9, 7};

        bubbleSort(data.clone());
        selectionSort(data.clone());
        insertionSort(data.clone());
        mergeSort(data.clone());
        quickSort(data.clone());
    }

    // ================= Bubble Sort =================
    private static void bubbleSort(int[] arr) {
        boolean swapped;

        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            // Optimization: stop if array is already sorted
            if (!swapped) break;
        }

        System.out.println("Bubble Sort     : " + Arrays.toString(arr));
    }

    // ================= Selection Sort =================
    private static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }

        System.out.println("Selection Sort  : " + Arrays.toString(arr));
    }

    // ================= Insertion Sort =================
    private static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("Insertion Sort  : " + Arrays.toString(arr));
    }

    // ================= Merge Sort =================
    private static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Merge Sort      : " + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    // ================= Quick Sort =================
    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Quick Sort      : " + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    // ================= Utility =================
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
