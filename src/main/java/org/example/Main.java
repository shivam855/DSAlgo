package org.example;
// 25/12/2025 --> kadane's algorithm, prefixSum;
// 26/12/2025 --> sliding window, 2 pointer, two sum, three sum.
// 27/12/2025 --> missing number approach, just one mistake, prefix String
// TODO --> prefixsum + map
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
    }

    public void longestConsecutive() {
        int [] arr = {2, 6, 1, 9, 4, 5, 3}; // --> 1,2,3,4,5,6,9
        SortedSet<Integer> sortedSet = new TreeSet<>();
        for(int i : arr) {
            sortedSet.add(i);
        }
        int longest = 0;
        int current = 0;
        Integer prev = null;

        for (Integer num : sortedSet) {
            if (prev != null && num == prev + 1) {
                current++;
            } else {
                current = 1;
            }
            longest = Math.max(longest, current);
            prev = num;
        }
        System.out.println(longest);
    }
//   find just one mismatch.
    private void mismatch() {
        String [] arr = {"bana", "apple", "banaba", "bananza"};
        String str = "banana";
        for(String s : arr) {
            if(s.length() == str.length()) {
                int count = 0;
                String str1 = "";
                for(int i = 0; i < s.length(); i++) {
                    if(s.charAt(i) != str.charAt(i)) {
                        str1 += s.charAt(i);
                        count++;
                    }
                }
                if(count == 1) {
                    System.out.println(true);
                    System.out.println(str1);
                    break;
                }
            } else {
                System.out.println(false);
            }

        }
    }

//    find missing number with XOR.
    private void missingNumber() {
        int [] arr = {1,0,3,4,5,2};
        int n = 6;
        int a = 0; // 0000
        for(int i = 0; i <= n; i++) {
            a = a ^ i; // 0 ^ 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 --> 0000 ^ 0001 ^ 0010 ^ 0011 ^ 0100 ^ 0101 ^ 0110
        }
        System.out.println(a); //  0111
        for(int i : arr) {
            a = a ^ i; // 0111 ^ 0001 --> 0110
        }
        System.out.println(a);
    }

    public void lexicographicallyDescending_Order() {
        String a = "for";
        int [] ch = new int[26];
        for(int i = 0; i < a.length(); i++) {
            ch[a.charAt(i) - 'a']++;
        }
        String s = "";
        for(int i = ch.length-1 ; i >= 0; i--) {
            if(ch[i] != 0) {
                while(ch[i] > 0) {
                    s += (char) (i + 'a');
                    ch[i]--;
                }
            }
        }
        System.out.println(s);
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

    //   Find Prefix String
    private static void prefixString() {
        String s = "shiva shivam shikha";
        String [] str = s.split(" ");
        String prefix = str[0];
        for(int i = 1; i < str.length; i++) {
            while(!str[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        System.out.println(prefix); //  output : shi;
    }
}