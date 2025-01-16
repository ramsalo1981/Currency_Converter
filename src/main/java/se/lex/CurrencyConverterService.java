package se.lex;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CurrencyConverterService {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        int choice;
        do {
            choice = displayMenuAndGetChoice();
            handleMenuChoice(choice);
            System.out.println();
        } while (choice != 5);
    }

    private int displayMenuAndGetChoice() {
        System.out.println("Currency Converter Menu");
        System.out.println("1. Convert SEK to USD");
        System.out.println("2. Convert SEK to EUR");
        System.out.println("3. Convert USD to SEK");
        System.out.println("4. Convert EUR to SEK");
        System.out.println("5. Exit");
        System.out.print("Select an option: ");

        return getValidChoice();
    }

    private int getValidChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 5) {
                    return choice;
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                convertCurrency("SEK", "USD");
                break;
            case 2:
                convertCurrency("SEK", "EUR");
                break;
            case 3:
                convertCurrency("USD", "SEK");
                break;
            case 4:
                convertCurrency("EUR", "SEK");
                break;
            case 5:
                System.out.println("Exiting the program.");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void convertCurrency(String fromCurrency, String toCurrency) {
        System.out.print("Enter amount in " + fromCurrency + ": ");
        double amount = getValidAmount();
        double convertedAmount = Currency.convert(fromCurrency, toCurrency, amount);

        // Get current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Display the result
        System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, toCurrency);
        System.out.println("Conversion Date and Time: " + now.format(formatter));
    }

    private double getValidAmount() {
        while (true) {
            try {
                double amount = Double.parseDouble(scanner.nextLine());
                if (amount < 0) {
                    System.out.println("Amount cannot be negative. Please enter a valid amount.");
                } else {
                    return amount;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }
    }
}
