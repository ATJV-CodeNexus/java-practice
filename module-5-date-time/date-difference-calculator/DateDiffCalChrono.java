import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateDiffCalChrono {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the format in which you want to feed the dates in");
        String dateFormatStr = scanner.nextLine();

        try {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(dateFormatStr);

            System.out.println("Input the date in " + dateFormatStr + " format");
            String rawDate1 = scanner.nextLine();
            LocalDate givenDate1 = LocalDate.parse(rawDate1, dateFormat);

            System.out.println("Input another date in " + dateFormatStr + " format");
            String rawDate2 = scanner.nextLine();
            LocalDate givenDate2 = LocalDate.parse(rawDate2, dateFormat);

            System.out.println("\nThe given date is " + givenDate1.format(dateFormat));
            System.out.println("\nThe other given date is " + givenDate2.format(dateFormat));

            if (givenDate1.isEqual(givenDate2)) {
                System.out.println("Both dates are the same");
            } else {
                System.out.println("The diff is " +
                        ChronoUnit.DAYS.between(givenDate1, givenDate2) + " day(s)");
            }
        } catch (DateTimeParseException dte) {
            System.out.println("Invalid input. Please try again!");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again!");
        }

        scanner.close();
    }
}
