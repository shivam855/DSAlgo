package org.example;
// 25/12/2025 --> kadane's algorithm, prefixSum;
// 26/12/2025 --> sliding window, 2 pointer, two sum, three sum.
// TODO --> prefixsum + map
import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    //    sliding window works with unsorted array and positive numbers
    private void slidingWin() {
        int [] arr = {2,8,1,11,15};
        int target = 20;

        int currSum = 0, des = 0;
        for(int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            while (currSum > target) {
                currSum -= arr[des];
                des++;
            }
            if(target == currSum) {
                System.out.println(true);
                System.out.println(currSum + " " + i + " " + des);
            }
        }
    }

    //    2, 3 pointer approach used by sorted array
    private void twoSumSortedArr() {
        int [] arr = {2,8,1,11,15};
        int target = 25;
        for(int i = 0; i < arr.length; i++) {
            int l = i + 1, r = arr.length - 1;
            while (l < r) {
                if (arr[l] + arr[r] + arr[i] == target ) {
                    System.out.println(arr[i] + " " + arr[l] + " " + arr[r]);
                    break;
                } else if (arr[l] + arr[r] < target) l++;
                else r--;
            }
        }
    }
    //    2 sum unsorted with map or set.
    private void twoSumUnsorted() {
        int [] arr = {2,8,1,11,15};
        int target = 25;
        Map<Integer, Integer> a = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(a.get(target - arr[i]) != null) {
                System.out.println(arr[i] + " " + (target - arr[i]));
            }
            a.put(arr[i], target - arr[i]);
        }
    }
    //    kadane's algorithm
    private void kadanesAlgorithm() {
        int [] arr = {2, 3, -8, 7, -1, 2, 3};
        int y = arr[0];
        int x = arr[0];
        for(int i = 1; i < arr.length; i++) {
            y = Math.max(arr[i], y + arr[i]);
            x = Math.max(x, y);
        }
        System.out.println(x);
    }

    //    prefixSum
    private static int[] prefixSum() {
        int [] arr = {2, 3, -8, 7, -2, 2, 3};
        int [] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }
//        System.out.println(Arrays.toString(prefix));
        return prefix;
    }

    private static int getSum(int l, int r) {
        if(l == 0) {
            return prefixSum()[r];
        } else {
            return prefixSum()[r] - prefixSum()[l-1];
        }
    }

    //    incomplete.
    private static void prefixString() {
        String s = "shiva shivam shikha";
//        output : shi;
        String str = s.replaceAll(" ", "");
        int [] ch = new int[26];
        for(int i = 0; i < str.length(); i++) {
            ch[str.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(ch));
    }
}