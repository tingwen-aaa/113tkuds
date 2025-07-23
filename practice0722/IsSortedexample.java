package practice0722;

public class IsSortedexample {

    public static boolean isSorted(int[] arr, int index) {
        if (index >= arr.length - 1) {
            return true;
        }

        if (arr[index] > arr[index + 1]) {
            return false;
        }

        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {1, 3, 2, 4, 5};
        int[] a3 = {10};
        int[] a4 = {};

        System.out.println("a1 sorted? " + isSorted(a1, 0));
        System.out.println("a2 sorted? " + isSorted(a2, 0));
        System.out.println("a3 sorted? " + isSorted(a3, 0));
        System.out.println("a4 sorted? " + isSorted(a4, 0));
    }
}
