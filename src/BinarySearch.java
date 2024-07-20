//Class for binary search algorithm
public class BinarySearch {
    // Method to perform the BinarySearch algorithm
    public int search(double[] array, double target, int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] > target) {
                return search(array, target, low, mid - 1);
            }
            return search(array, target, mid + 1, high);
        }
        return -1; // Value not found
    }
}

