import java.util.Random;
import java.util.Scanner;

// lab01, task 2
public class NumberGuesser {
    public static void main(String[] args) {
        startNumberGuesser();
    }

    public static void startNumberGuesser() {
        Random random = new Random();
        int targetNumber = random.nextInt(101);
        int attempts = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guesser!");
        System.out.println("I've selected a random number between 0 and 100. Try to guess it.");

        while (true) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You've guessed the number: " + targetNumber);
                System.out.println("Number of attempts: " + attempts);
                break;
            } else if (userGuess < targetNumber) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }
        }

        scanner.close();
    }
}
