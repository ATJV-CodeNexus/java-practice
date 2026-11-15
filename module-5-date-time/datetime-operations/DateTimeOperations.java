// Import necessary classes for date-time manipulation and user input
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimeOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the current date and time in the default time zone
        ZonedDateTime dateTime = ZonedDateTime.now();

        // Print the current date and time in the default format
        System.out.println("\nDefault Format: " + dateTime);

        // Loop until the user chooses to exit
        while (true) {
            // Display the menu options to the user
            System.out.println("\nPress 1 for adding to or deleting from the current date/time," +
                    "\nPress 2 for changing the timezone," +
                    "\nAny other key to exit");

            String userAction = scanner.nextLine();

            // Option 1: Add or delete time units
            if (userAction.equals("1")) {
                System.out.println("Enter which unit of time you want to add/delete:\n" +
                        "d - days, M - months, y - years, h - hours, m - minutes, s - seconds, w - weeks");
                String unitToChange = scanner.nextLine();

                System.out.println("Enter the quantity to change (for example, 3):");
                long qtyToChange;
                try {
                    qtyToChange = Long.parseLong(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number");
                    continue;
                }

                System.out.println("\nPress 'a' to add, 'd' to delete," +
                        "\nAny other key to go back to the main menu");
                String addOrDel = scanner.nextLine();

                // Variable to store the modified date and time
                ZonedDateTime newDateTime = null;

                if (addOrDel.equals("a")) {
                    switch (unitToChange) {
                        case "d":
                            newDateTime = dateTime.plusDays(qtyToChange);
                            break;
                        case "M":
                            newDateTime = dateTime.plusMonths(qtyToChange);
                            break;
                        case "y":
                            newDateTime = dateTime.plusYears(qtyToChange);
                            break;
                        case "h":
                            newDateTime = dateTime.plusHours(qtyToChange);
                            break;
                        case "m":
                            newDateTime = dateTime.plusMinutes(qtyToChange);
                            break;
                        case "s":
                            newDateTime = dateTime.plusSeconds(qtyToChange);
                            break;
                        case "w":
                            newDateTime = dateTime.plusWeeks(qtyToChange);
                            break;
                        default:
                            System.out.println("Invalid input");
                            continue; // Go back to the main menu
                    }
                } else if (addOrDel.equals("d")) {
                    switch (unitToChange) {
                        case "d":
                            newDateTime = dateTime.minusDays(qtyToChange);
                            break;
                        case "M":
                            newDateTime = dateTime.minusMonths(qtyToChange);
                            break;
                        case "y":
                            newDateTime = dateTime.minusYears(qtyToChange);
                            break;
                        case "h":
                            newDateTime = dateTime.minusHours(qtyToChange);
                            break;
                        case "m":
                            newDateTime = dateTime.minusMinutes(qtyToChange);
                            break;
                        case "s":
                            newDateTime = dateTime.minusSeconds(qtyToChange);
                            break;
                        case "w":
                            newDateTime = dateTime.minusWeeks(qtyToChange);
                            break;
                        default:
                            System.out.println("Invalid input");
                            continue; // Go back to the main menu
                    }
                } else {
                    System.out.println("Invalid input");
                    continue; // Go back to the main menu
                }

                System.out.println("\n\nEnter the format you would like to print the date and time in:");
                String strDateTimeFormat = scanner.nextLine();

                try {
                    DateTimeFormatter newDateTimeFormat = DateTimeFormatter.ofPattern(strDateTimeFormat);
                    System.out.println("The date and time is: " + newDateTime.format(newDateTimeFormat));
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid format pattern");
                }
            }

            // Option 2: Change the time zone
            else if (userAction.equals("2")) {
                System.out.println("Check the following Zone options:");
                for (String zoneId : ZoneId.getAvailableZoneIds()) {
                    System.out.println(zoneId);
                }

                System.out.println("\n\nEnter the time zone you want to get the current time for:");
                String newZone = scanner.nextLine();

                try {
                    ZonedDateTime newZoneDateTime = dateTime.withZoneSameInstant(ZoneId.of(newZone));

                    DateTimeFormatter newDateTimeFormat = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm:ss a zzz");

                    System.out.println("The date and time is: " + newZoneDateTime.format(newDateTimeFormat));
                } catch (Exception e) {
                    System.out.println("Invalid time zone");
                }
            }

            // Exit the program
            else {
                break;
            }
        }

        scanner.close();
    }
}
