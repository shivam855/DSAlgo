package searchingAndSorted;

public class searching {
    public static void main(String[] args) {
        searching obj = new searching();
        obj.binarySearch();
        obj.linearSearch();
        obj.jumpSearch();
    }

//    Linear search
    private void linearSearch() {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        int target = 9;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                System.out.println("found : " + i);
                break;
            }
        }
    }

    // Binary Search
    private void binarySearch() {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        int target = 9;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                System.out.println("found : " + mid);
                break;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println("Not found");
    }

//    Jump to Search
    private void jumpSearch() {
        int[] arr = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        int t = 10;

        if(arr[0]> t || arr[arr.length-1] < t  ){
            System.out.println("not found");
            return;
        }

        for(int i = 0 ; i < arr.length; i += 4){
            if(arr[i] == t){
                System.out.println(t + " found at " + i);
                break;
            }
            else if (arr[i] > t){
                i--;
                while (arr[i] >= t ) {
                    if (arr[i] == t) {
                        System.out.println(t + " found at " + i);
                        break;
                    }
                    i--;
                }
                break;
            }
        }
    }
}
