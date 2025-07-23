package practice0722;

public class ArrayMaxExample {
    
    public static int findMax(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }
        int maxOfRest = findMax(arr, index + 1);
        return Math.max(arr[index], maxOfRest);
    }
    
    public static void main(String[] args) {
        int[] numbers = {3, 7, 2, 9, 1};
        System.out.println("最大值: " + findMax(numbers, 0));
        
        int[] moreNumbers = {15, 8, 23, 4};
        System.out.println("最大值: " + findMax(moreNumbers, 0));
    }
}
