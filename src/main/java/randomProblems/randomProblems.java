package randomProblems;

import java.util.Arrays;

public class randomProblems {
    public static void main(String[] args) {
        randomProblems obj = new randomProblems();
        obj.moveAll1toEnd();
        obj.maxProduct();
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
}
