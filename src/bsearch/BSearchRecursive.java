package bsearch;

public class BSearchRecursive {

    public static void main(String[] args) {
        int key = 8;
        int arr[] = new int[]{3, 6, 8, 12, 14, 17, 25, 29, 31, 36, 42, 47, 53, 55, 62};
        int index = bSearch(arr, 0, arr.length - 1, key);
        System.out.println("index:" + index);
        if (index == -1) {
            System.out.println("Not Found");
        } else {
            System.out.println(arr[index]);
        }

    }

    private static int bSearch(int arr[], int start, int end, int key) {
        int mid = start + (end - start) / 2;

        System.out.println("start:" + start + " end:" + end + " key:" + key + " mid:" + mid);
        if (start > end) {
            System.out.println("return -1");
            return -1;
        }

        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] < key) {
            return bSearch(arr, mid + 1, end, key);
        } else {
            return bSearch(arr, start, mid - 1, key);
        }
    }
}
