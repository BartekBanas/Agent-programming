import java.util.Arrays;
import java.util.Random;

// lab01, task 3
public class ArrayStatistics {
    public static void main(String[] args) {
        int[] numbers = generateRandomArray(11);

        System.out.println("Generated array: " + Arrays.toString(numbers));

        int max = findMax(numbers);
        int secondLargest = findSecondLargest(numbers);

        System.out.println("Maximum value: " + max);
        System.out.println("Second largest value: " + secondLargest);
    }

    public static int[] generateRandomArray(int length) {
        int[] array = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int findSecondLargest(int[] array) {
        int max = findMax(array);
        int secondLargest = Integer.MIN_VALUE;

        for (int j : array) {
            if (j != max && j > secondLargest) {
                secondLargest = j;
            }
        }

        return secondLargest;
    }
}