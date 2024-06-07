import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Guess the Number Game!");

        boolean playAgain = true;
        int totalRounds = 0;
        int totalAttempts = 0;

        while (playAgain) {
            totalRounds++;
            int number = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10; // Limit the number of attempts

            System.out.println("\nRound " + totalRounds + ":");
            System.out.println("Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");

                try {
                    int guess = Integer.parseInt(scanner.nextLine());
                    attempts++;
                    totalAttempts++;

                    if (guess < number) {
                        System.out.println("Too low!");
                    } else if (guess > number) {
                        System.out.println("Too high!");
                    } else {
                        System.out.println("Congratulations! You've guessed the correct number!");
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + number + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.nextLine().trim().equalsIgnoreCase("yes");
        }

        System.out.println("\nGame Over! You've played " + totalRounds + " rounds with a total of " + totalAttempts + " attempts.");
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}
