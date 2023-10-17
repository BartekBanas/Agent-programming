import java.util.Scanner;

// lab01, task 8
public class DistanceConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        double kilometers = scanner.nextDouble();
        scanner.close();

        double landMiles = convertToLandMiles(kilometers);
        double nauticalMiles = convertToNauticalMiles(kilometers);

        System.out.println(kilometers + " kilometers is approximately:");
        System.out.println("  - " + landMiles + " land miles");
        System.out.println("  - " + nauticalMiles + " nautical miles");
    }

    public static double convertToLandMiles(double kilometers) {
        return kilometers * 0.621371;
    }

    public static double convertToNauticalMiles(double kilometers) {
        return kilometers * 0.539957;
    }
}