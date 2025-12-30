package gfg;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class gfgProblem {
    public static void main(String[] args) {
        gfgProblem obj = new gfgProblem();
        obj.sortInWave();
    }
//    https://www.geeksforgeeks.org/problems/multiply-two-strings/1?page=2&category=Arrays,Strings&status=unsolved&sortBy=submissions
    private void productString() {
        String s1 = "0033", s2 = "2";
        BigInteger x = new BigInteger(s1);
        BigInteger y = new BigInteger(s2);
        System.out.println(x.multiply(y).toString());
    }
//
    private void getAlternateNumberFrmArray() {
        int arr[] = {1, 2, 3, 4, 5};
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0; i < arr.length; i = i + 2) {
            a.add(arr[i]);
        }
        System.out.println(a.toString());
    }

//https://www.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1?page=2&category=Arrays,Strings&status=unsolved&sortBy=submissions
    private void Alternate_Positive_Negative() {
        ArrayList<Integer> arr = new ArrayList<>();
        int [] a = {9, 4, -2, -1, 5, 0, -5, -3, 2};
        for(int i : a) {
            arr.add(i);
        }
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        
        for (int num : arr) {
            if (num >= 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }
        
        int i = 0, j = 0, k = 0;
        while (i < pos.size() && j < neg.size()) {
            arr.set(k++, pos.get(i++));
            arr.set(k++, neg.get(j++));
        }
        
        while (i < pos.size()) {
            arr.set(k++, pos.get(i++));
        }
        
        while (j < neg.size()) {
            arr.set(k++, neg.get(j++));
        }
        System.out.println(arr);
    }
// https://www.geeksforgeeks.org/problems/wave-array-1587115621/1?page=1&category=Arrays,Strings&status=unsolved,attempted&sortBy=submissions
    private void sortInWave() {
        int [] arr = {1};
        for(int i = 0; i < arr.length - 1; i = i + 2) {
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
//    https://www.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1?page=1&category=Arrays,Strings&status=unsolved&sortBy=submissions
}