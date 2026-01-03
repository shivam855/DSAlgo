package gfg;

import java.math.BigInteger;
import java.util.*;

public class gfgProblem {
    public static void main(String[] args) {
        gfgProblem obj = new gfgProblem();
        obj.filterByDigits();
        int[] arr = {5, 1, 2, 3, 4};
        System.out.println(findKRotation(arr));
        isFrequencyUnique();
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
//    https://www.geeksforgeeks.org/problems/intersection-of-two-arrays2404/1?page=2&category=Arrays&status=unsolved&sortBy=submissions
    public static int intersectSize() {
        int a[] = {1, 2, 4, 3, 5, 6}, b[] = {3, 4, 5, 6, 7};
        Map<Integer, Integer> m = new HashMap<>();
        for(int i : a) {
            m.put(i , m.getOrDefault(i, 0) + 1);
        }
        int count = 0;
        for(int i : b) {
            if (m.containsKey(i) && m.get(i) > 0) {
                count++;
            }
        }
        return count;
    }

// https://www.geeksforgeeks.org/problems/numbers-containing-1-2-and-32555/1?page=2&category=Arrays&status=unsolved&sortBy=submissions
    public void filterByDigits() {
        ArrayList<Integer> arr = new ArrayList<>(List.of(1,2,3,12));
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : arr) {
            int temp = num;
            boolean valid = true;
            while (temp > 0) {
                int digit = temp % 10;
                if (digit != 1 && digit != 2 && digit != 3) {
                    valid = false;
                    break;
                }
                temp /= 10;
            }
            if (valid) {
                result.add(num);
            }
        }
        if (result.isEmpty()) {
            result.add(-1);
        }
        System.out.println(result);
    }

//    https://www.geeksforgeeks.org/problems/longest-distinct-characters-in-string5848/1?page=1&category=Strings&status=unsolved,attempted&sortBy=submissions
//    https://www.geeksforgeeks.org/problems/length-of-the-longest-substring3036/1?page=1&category=Strings&status=unsolved,attempted&sortBy=submissions
//    (Sliding Window + Fixed Array)
    public int longestSubstring(String s) {
        int[] lastIndex = new int[256]; // constant space
        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1;
        }
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            // if character already seen in current window
            if (lastIndex[ch] >= left) {
                left = lastIndex[ch] + 1;
            }
            lastIndex[ch] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
//  "aacbacc".replace(/b/g, "").replace(/ac/g, "") --> output is ac
//    https://www.geeksforgeeks.org/problems/rotation4723/1?page=1&category=Arrays&status=unsolved&sortBy=submissions
    public static int findKRotation(int[] arr) {
        int l = 0, r = arr.length - 1;
        int n = arr.length;
        while (l <= r) {
            // Case 1: array already sorted
            if (arr[l] <= arr[r]) {
                return l;
            }
            int mid = l + (r - l) / 2;
            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;
            // Case 2: mid is the minimum element
            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                return mid;
            }
            // Case 3: decide which half to search
            if (arr[mid] >= arr[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return 0;
    }

//    https://www.geeksforgeeks.org/problems/missing-element-of-ap2228/1?page=1&category=Arrays&status=unsolved&sortBy=submissions
//    few test cases failing
    public static int findMissing(int[] arr) {
        int n = arr.length;
        int a = arr[0];

        // Step 1: find correct common difference
        int d = arr[1] - arr[0];
        if (n > 2) {
            d = Math.min(
                    Math.abs(arr[1] - arr[0]),
                    Math.abs(arr[2] - arr[1])
            );
            if (arr[1] < arr[0]) d = -d;
        }

        int expectedLast = a + (n - 1) * d;

        int l = 0, r = n - 2;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            // Missing element found
            if (arr[mid] + d != arr[mid + 1]) {
                return arr[mid] + d;
            }
            // Decide search direction
            else if (arr[mid] > a + mid * d) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // No missing inside → return next AP term
        return expectedLast + d;
    }


//   https://www.geeksforgeeks.org/problems/maximum-value-in-a-bitonic-array3001/1?page=1&category=Arrays&status=unsolved&sortBy=submissions

//   https://www.geeksforgeeks.org/problems/unique-frequencies-of-not/1?page=1&category=Map,set,Kadane&difficulty=Basic,Easy&status=unsolved&sortBy=submissions
    public static void isFrequencyUnique() {
        int n = 5;
        int[] arr = {1, 1, 2, 5, 5};
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        Set<Integer> freqSet = new HashSet<>();
        for (int freq : freqMap.values()) {
            if (!freqSet.add(freq)) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }

    //    https://www.geeksforgeeks.org/problems/second-most-repeated-string-in-a-sequence0534/1?page=1&category=Map,set,Kadane&difficulty=Basic,Easy&status=unsolved&sortBy=submissions
    String secFrequent() {
        String [] arr = {"aaa", "bbb", "ccc", "bbb", "aaa", "aaa"};
        Map<String, Integer> m = new HashMap<>();
        for(String s : arr) {
            m.put(s, m.getOrDefault(s, 0) + 1);
        }
        int sec = 0, max = 0;
        for(int i : m.values()) {
            if(i > max) {
                sec = max;
                max = i;
            } else if(sec < i && i != max) {
                sec = i;
            }
        }

        for(Map.Entry<String, Integer> e : m.entrySet())
            if(e.getValue() == sec)
                return e.getKey();
        return "";
    }
//    https://www.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1?page=1&category=Map,set,Kadane&difficulty=Medium&status=unsolved&sortBy=submissions
//    https://www.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1?page=1&category=Arrays,Strings&status=unsolved&sortBy=submissions
}