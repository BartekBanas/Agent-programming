// lab01, task 1
public class NumberConverter {
    public static void main(String[] args) {
        printConvertedNumbers(0, 100);
    }

    public static void printConvertedNumbers(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(convertNumber(i));
        }
    }

    public static String convertNumber(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "xyxy";
        } else if (number % 3 == 0) {
            return "xxx";
        } else if (number % 5 == 0) {
            return "yyy";
        } else {
            return Integer.toString(number);
        }
    }
}
