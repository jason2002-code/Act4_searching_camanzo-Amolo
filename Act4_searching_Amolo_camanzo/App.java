import java.util.Arrays;
import java.util.Scanner;

class SearchingAlgorithms {

    // Linear Search
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    static int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Jump Search
    static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.sqrt(n);

        int prev = 0;
        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) {
                return -1;
            }
        }

        while (arr[prev] < target) {
            prev++;
            if (prev == Math.min(step, n)) {
                return -1;
            }
        }

        if (arr[prev] == target) {
            return prev;
        }

        return -1;
    }

    // Exponential Search
    static int exponentialSearch(int[] arr, int target) {
        int n = arr.length;
        if (arr[0] == target) {
            return 0;
        }

        int i = 1;
        while (i < n && arr[i] <= target) {
            i *= 2;
        }

        return binarySearch(arr, i / 2, Math.min(i, n - 1), target);
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Project Name: Act 4 Searching - [Your Last Name] [Your Last Name]");
        System.out.println("Choose a searching algorithm to perform:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.println("3. Jump Search");
        System.out.println("4. Exponential Search");
        System.out.print("Enter your choice (1-4): ");

        int choice = scanner.nextInt();

        System.out.print("Enter no. of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        if (choice == 2 || choice == 3) {
            Arrays.sort(arr);
            System.out.println("Sorted array: " + Arrays.toString(arr));
        }

        System.out.print("Enter target element: ");
        int target = scanner.nextInt();

        int result = -1;

        switch (choice) {
            case 1:
                result = SearchingAlgorithms.linearSearch(arr, target);
                break;
            case 2:
                result = SearchingAlgorithms.binarySearch(arr, 0, n - 1, target);
                break;
            case 3:
                result = SearchingAlgorithms.jumpSearch(arr, target);
                break;
            case 4:
                result = SearchingAlgorithms.exponentialSearch(arr, target);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (result == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at index: " + result);
        }

        scanner.close();
    }
}