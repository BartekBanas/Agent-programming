// lab01, task 7
public class NumberPyramidPrinter {
    public static void main(String[] args) {
        int size = 10;

        printPyramid(size);
    }

    public static void printPyramid(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size - i; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("0");
            }

            System.out.println();
        }
    }
}