// Import necessary classes for date manipulation, formatting, and user input
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateDiffCalculator2 {

    // Method to calculate and return the difference between two dates as a string
    public static String getDiff(LocalDate d1, LocalDate d2) {
        // Calculate the period (difference) between the two dates
        Period period = d1.until(d2);

        String diffStr = "The difference is ";

        if (period.getYears() != 0) {
            diffStr = diffStr + period.getYears() + " years, ";
        }

        if (period.getMonths() != 0) {
            diffStr = diffStr + period.getMonths() + " months, ";
        }

        if (period.getDays() != 0) {
            diffStr = diffStr + period.getDays() + " day(s)";
        }

        return diffStr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the format in which you want to feed the dates in:");
        String dateFormatStr = scanner.nextLine();

        try {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(dateFormatStr);

            System.out.println("Input the date in " + dateFormatStr + " format:");
            String rawDate1 = scanner.nextLine();
            LocalDate givenDate1 = LocalDate.parse(rawDate1, dateFormat);

            System.out.println("Input another date in " + dateFormatStr + " format:");
            String rawDate2 = scanner.nextLine();
            LocalDate givenDate2 = LocalDate.parse(rawDate2, dateFormat);

            System.out.println("\nThe given date is " + givenDate1.format(dateFormat));
            System.out.println("\nThe other given date is " + givenDate2.format(dateFormat));

            if (givenDate1.isEqual(givenDate2)) {
                System.out.println("Both dates are the same");
            } else {
                if (givenDate1.isBefore(givenDate2)) {
                    System.out.println(getDiff(givenDate1, givenDate2));
                } else {
                    System.out.println(getDiff(givenDate2, givenDate1));
                }
            }
        } catch (DateTimeParseException dte) {
            System.out.println("Invalid input. Please try again!");
        } catch (Exception e) {
            // Handles anything else, such as an unknown format pattern
            System.out.println("Invalid input. Please try again!");
        }

        scanner.close();
    }
}
