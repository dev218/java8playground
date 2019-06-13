package minh.interview;

public class Merge2SortedArray {

    public static void main(String[] args) {
        int[] a = {1, 4, 6, 7, 8, 9, 10, 15};
        int[] b = {2, 2, 3, 4, 5, 8, 10, 14, 21};

        int[] c = merge(a, b);
        for (int value : c) {
            System.out.println(value);
        }
    }

    private static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];

        int i = 0, j = 0;

        while (i + j < a.length + b.length) {
            if ( (i < a.length) && (a[i] < b[j]) ) {
                c[i+j] = a[i];
                i++;
            } else {
                c[i+j] = b[j];
                j++;
            }
        }
        return c;
    }
}
