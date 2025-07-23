package practice0722;

public class StringReverseExample {
    
    public static String reverseString(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return str.charAt(str.length() - 1) + 
               reverseString(str.substring(0, str.length() - 1));
    }
    
    public static void main(String[] args) {
        System.out.println("Reverse 'hello': " + reverseString("hello"));
        System.out.println("Reverse 'java': " + reverseString("java"));
        System.out.println("Reverse 'a': " + reverseString("a"));
    }
}
