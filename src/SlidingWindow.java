public class SlidingWindow {
    // Find the maximum sum of k consecutive elements
    public int maxSum(int[] arr, int k) {
        if (arr.length < k) {
            throw new IllegalArgumentException("Array size is smaller than the window size.");
        }

        // Calculate the sum of the first window
        int maxSum = 0, currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        maxSum = currentSum;

        // Slide the window over the array
        for (int i = k; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}