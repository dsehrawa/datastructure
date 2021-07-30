package bsearch;

public class BSearch {

    public static void main(String[] args) {
        int key = Integer.MAX_VALUE;
        int arr[] = new int[]{3, 6, 8, 12, 14, 17, 25, 29, 31, 36, 42, 47, 53, 55, 62};
        int index = bSearch(arr, key);
        if (index == -1) {
            System.out.println("Not Found");
        } else {
            System.out.println(arr[index]);
        }

    }

    private static int bSearch(int arr[], int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
