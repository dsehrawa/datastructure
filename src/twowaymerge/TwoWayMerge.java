package twowaymerge;

import java.util.Arrays;

public class TwoWayMerge {
    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 4, 5};
        int b[] = new int[]{6, 7, 8, 9, 10, 11, 12};
        int c[] = new int[12];

        int i = 0, k = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        for (; i < a.length; i++) {
            c[k++] = a[i];
        }

        for (; j < b.length; j++) {
            c[k++] = b[j];
        }
        System.out.println(Arrays.toString(c));
    }
}