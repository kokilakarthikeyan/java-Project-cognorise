import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Try to guess it.");

        // Generate a random number between 1 and 100
        int secretNumber = (int) (Math.random() * 100) + 1;
        int guess;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess == secretNumber) {
                hasGuessedCorrectly = true;
            } else if (guess < secretNumber) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }

        } while (!hasGuessedCorrectly);

        System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
        scanner.close();
    }
}
