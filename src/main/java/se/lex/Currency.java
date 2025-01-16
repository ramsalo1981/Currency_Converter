package se.lex;

public class Currency {
    private static final double SEK_TO_USD = 0.1;
    private static final double SEK_TO_EUR = 0.09;
    private static final double USD_TO_SEK = 10.0;
    private static final double EUR_TO_SEK = 11.0;

    public static double convert(String fromCurrency, String toCurrency, double amount) {
        return switch (fromCurrency) {
            case "SEK" -> convertFromSEK(toCurrency, amount);
            case "USD" -> convertFromUSD(toCurrency, amount);
            case "EUR" -> convertFromEUR(toCurrency, amount);
            default -> throw new IllegalArgumentException("Invalid currency: " + fromCurrency);
        };
    }

    private static double convertFromSEK(String toCurrency, double amount) {
        return switch (toCurrency) {
            case "USD" -> amount * SEK_TO_USD;
            case "EUR" -> amount * SEK_TO_EUR;
            default -> throw new IllegalArgumentException("Invalid currency: " + toCurrency);
        };
    }

    private static double convertFromUSD(String toCurrency, double amount) {
        return switch (toCurrency) {
            case "SEK" -> amount * USD_TO_SEK;
            default -> throw new IllegalArgumentException("Invalid currency: " + toCurrency);
        };
    }

    private static double convertFromEUR(String toCurrency, double amount) {
       return switch (toCurrency) {
            case "SEK" -> amount * EUR_TO_SEK;

            default -> throw new IllegalArgumentException("Invalid currency: " + toCurrency);

        };
    }
}
