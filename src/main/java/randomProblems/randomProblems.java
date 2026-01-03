package randomProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class randomProblems {
    public static void main(String[] args) {
        randomProblems obj = new randomProblems();
//        obj.moveAll1toEnd();
//        obj.maxProduct();
//        obj.productExceptSelf();
//        obj.firstRepeatedChar("geksforgeeks");
//        obj.findLongWordInString("good morning");
//        obj.binarySearch();
//        obj.rotateString();
        obj.pattern();
    }
    private void moveAll1toEnd() {
        int [] arr = {1, 0, 1, 2, 1, 3, 4};
//        OUTPUT : [0,2,3,4,1,1,1];
        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 1) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    private void maxProduct() {
        int [] arr = {3, -1, 4};
//        OUTPUT : 4;
        long prod = 1;
        long maxPrd = Long.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            prod *= arr[i];
            maxPrd = Math.max(maxPrd, prod);
            if(prod == 0) {
                prod = 1;
            }
        }
        prod = 1;
        for(int i = arr.length - 1; i >= 0; i--) {
            prod *= arr[i];
            maxPrd = Math.max(maxPrd, prod);
            if(prod == 0) {
                prod = 1;
            }
        }
        System.out.println(maxPrd);
    }
    private void productExceptSelf() {
        int [] arr = {1,2,3,4};
        int index = 1;
        int [] prefix = new int[arr.length];
        int [] suffix = new int[arr.length];
        int [] ans = new int[arr.length];

        prefix[0] = 1;
        for(int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i-1] * arr[i-1];
        }

        suffix[arr.length-1] = 1;
        for(int i = arr.length-2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * arr[i+1];
        }

//       multiply
        for(int i = 0; i < arr.length; i++) {
            ans[i] = prefix[i] * suffix[i];
        }

        System.out.println(Arrays.toString(ans));
    }

    private void firstRepeatedChar(String s) {
//        String s = "geksforgeeks";
        int [] ch = new int[26];
        char [] c = s.toCharArray();
        for(char i : c) {
            if(ch[i - 'a'] != 0) {
                System.out.println("First repeated char : " + i);
                break;
            }
            ch[i - 'a']++;
        }
    }
//    find longest word in a string
    private void findLongWordInString(String str) {
//        String str = "good morning";
        String [] arr = str.split(" ");
        String longest = "";
        for(String s : arr) {
            if(s.length() > longest.length()) {
                longest = s;
            }
        }
        System.out.println(longest);
    }
    private void binarySearch() {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        int target = 9;
        int l = 0, r = arr.length;
        System.out.println(bos(arr,  l, r, target));
    }

    private static int bos(int [] arr, int l, int r, int target) {
        if(l > r) return -1;
        int mid = l + ( r -l) /2;
        if(arr[mid] == target) {
            return mid;
        }
        else if (arr[mid] > target) {
            return bos(arr, l, mid - 1, target);
        }
        else {
            return bos(arr, mid + 1, r, target);
        }
    }

    private void rotateString2() {
        String str = "prince", target = "ceprin";
        for(int i = str.length() - 1 ; i >=  0; i--) {
            str = str.charAt(str.length() - 1) + str.substring(0, str.length() - 1);
            if(str.equals(target)) {
                System.out.println("String is rotated");
                System.out.println(str);
                break;
            }
        }
    }

    private void rotateString() {
        String str = "prince", target = "ceprin";
        String str1 = str.repeat(2);
        if(str1.indexOf(target) != -1) {
            System.out.println("String is rotated");
        }
    }

//   *****
//   **
//   ***
//   *
//   ***
//   **
//   *****
    public void pattern() {
        int row = 7;
        int count = 3;
        for(int i = 0; i < row; i++) {
            int x;
            int d = Math.abs(i - count) ;
            if(d == 3) {
                x = 5;
            } else if(d == 2) {
                x = 2;
            } else if(d == 1) {
                x = 3;
            } else {
                x = 1;
            }
            System.out.println("*".repeat(x));

        }
    }
}
