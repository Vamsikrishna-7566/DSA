import java.util.*;

public class RotateArray {

    // Function to reverse a portion of the array
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Function to rotate array left by d elements
    private static void rotateLeft(int[] arr, int d) {
        int n = arr.length;

        // Handle cases where d > n
        d = d % n;

        // Step 1: Reverse first d elements
        reverse(arr, 0, d - 1);

        // Step 2: Reverse remaining elements
        reverse(arr, d, n - 1);

        // Step 3: Reverse entire array
        reverse(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int d = 2;

        rotateLeft(arr, d);

        System.out.println("Rotated Array:");
        System.out.println(Arrays.toString(arr));
    }
}
