import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class MoodTracker {

    public static void main(String[] args) {

        ArrayList<Mood> moodsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Press 'a' to add mood\n" +
                    "'d' to delete mood(s)\n" +
                    "'e' to edit mood\n" +
                    "'s' to search for moods\n" +
                    "'M' to get all moods\n" +
                    "'w' to write the moods to a file\n" +
                    "Type 'Exit' to exit");

            String menuOption = scanner.nextLine();

            switch (menuOption) {
                case "a":

                    System.out.println("Enter the mood name: ");
                    String name = scanner.nextLine();

                    System.out.println("Do you want to add date and time? y/n");
                    String userChoice = scanner.nextLine();

                    Mood mood = null;

                    if (userChoice.equalsIgnoreCase("y")) {

                        try {
                            System.out.println("Add the date in dd/MM/yyyy format: ");
                            String dateStr = scanner.nextLine();
                            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate date = LocalDate.parse(dateStr, dateFormatter);

                            System.out.println("Add the time in HH:mm:ss format: ");
                            String timeStr = scanner.nextLine();
                            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                            LocalTime time = LocalTime.parse(timeStr, timeFormatter);

                            System.out.println("Add note to your mood");
                            String note = scanner.nextLine();
                            if (note.strip().isEmpty()) {
                                mood = new Mood(name, date, time);
                            } else {
                                mood = new Mood(name, date, time, note);
                            }

                        } catch (DateTimeParseException dfe) {
                            System.out.println("Incorrect format of date or time. Cannot create mood.\n" + dfe);
                            continue;
                        }

                    } else {
                        System.out.println("Add note to your mood");
                        String note = scanner.nextLine();
                        if (note.strip().isEmpty()) {
                            mood = new Mood(name);
                        } else {
                            mood = new Mood(name, note);
                        }
                    }

                    try {
                        boolean isValid = isMoodValid(mood, moodsList);
                        if (isValid) {
                            moodsList.add(mood);
                            System.out.println("The mood has been added to the tracker");
                        }
                    } catch (InvalidMoodException ime) {
                        System.out.println("The mood is not valid: " + ime.getMessage());
                    }

                    continue;

                case "d":
                    System.out.println("Press 1 to delete mood by date, or press 2 to delete " +
                            "mood by name, date and time");
                    String userOption = scanner.nextLine();

                    if (userOption.equalsIgnoreCase("1")) {
                        try {
                            System.out.println("Enter the date of the mood you want to delete in dd/MM/yyyy format:");
                            String dateStr = scanner.nextLine();
                            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate date = LocalDate.parse(dateStr, format);

                            boolean deleted = deleteMoods(date, moodsList);
                            if (deleted) {
                                System.out.println("The mood(s) have been deleted");
                            } else {
                                System.out.println("No matching mood found");
                            }
                        } catch (DateTimeParseException dfe) {
                            System.out.println("Incorrect format of date. Nothing deleted.\n" + dfe);
                            continue;
                        }
                    } else if (userOption.equalsIgnoreCase("2")) {
                        try {
                            System.out.println("Enter the name of the mood you want to be deleted.");
                            String moodName = scanner.nextLine();

                            System.out.println("Enter the date of the mood you want to delete in dd/MM/yyyy format:");
                            String dateStr = scanner.nextLine();
                            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate date = LocalDate.parse(dateStr, format);

                            System.out.println("Enter the time of the mood you want to delete in HH:mm:ss format:");
                            String timeStr = scanner.nextLine();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                            LocalTime time = LocalTime.parse(timeStr, formatter);

                            Mood moodToDelete = new Mood(moodName, date, time);

                            boolean deleted = deleteMood(moodToDelete, moodsList);
                            if (deleted) {
                                System.out.println("The mood has been deleted");
                            } else {
                                System.out.println("No matching mood found");
                            }
                        } catch (DateTimeParseException dfe) {
                            System.out.println("Incorrect format of date or time. Nothing deleted.\n" + dfe);
                            continue;
                        }
                    }

                    continue;

                case "e":

                    try {
                        System.out.println("Enter the name of the mood you want to edit");
                        String moodName = scanner.nextLine();

                        System.out.println("Enter the date of the mood you want to edit in dd/MM/yyyy format:");
                        String dateStr = scanner.nextLine();
                        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate date = LocalDate.parse(dateStr, format);

                        System.out.println("Enter the time of the mood you want to edit in HH:mm:ss format:");
                        String timeStr = scanner.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                        LocalTime time = LocalTime.parse(timeStr, formatter);

                        System.out.println("Add the new note for this mood");
                        String note = scanner.nextLine();

                        if (note.strip().isEmpty()) {
                            System.out.println("No notes entered.");
                            continue;
                        }

                        Mood moodToEdit = new Mood(moodName, date, time, note);

                        boolean edited = editMood(moodToEdit, moodsList);
                        if (edited) {
                            System.out.println("Edited successfully");
                        } else {
                            System.out.println("No matching mood could be found");
                        }
                    } catch (DateTimeParseException dfe) {
                        System.out.println("Incorrect format of date or time. Nothing edited.");
                        continue;
                    }
                    continue;

                case "s":

                    System.out.println("Press 1 to search by date or 2 to search mood by name, date and time.");
                    String option = scanner.nextLine();

                    if (option.equalsIgnoreCase("1")) {
                        try {
                            System.out.println("Enter the date in dd/MM/yyyy format");
                            String dateStr = scanner.nextLine();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate date = LocalDate.parse(dateStr, formatter);
                            searchMood(date, moodsList);

                        } catch (DateTimeParseException dfe) {
                            System.out.println("Invalid date input");
                            continue;
                        }

                    } else if (option.equalsIgnoreCase("2")) {
                        try {
                            System.out.println("Enter the name of the mood to search");
                            String searchName = scanner.nextLine();
                            System.out.println("Enter the date in dd/MM/yyyy format.");
                            String dateStr = scanner.nextLine();
                            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate date = LocalDate.parse(dateStr, format);
                            System.out.println("Enter the time in HH:mm:ss format.");
                            String timeStr = scanner.nextLine();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                            LocalTime time = LocalTime.parse(timeStr, formatter);

                            Mood moodToSearch = new Mood(searchName, date, time);

                            searchMoods(moodToSearch, moodsList);

                        } catch (DateTimeParseException dfe) {
                            System.out.println("Invalid date or time input");
                            continue;
                        }
                    }
                    continue;

                case "M":

                    if (moodsList.isEmpty()) {
                        System.out.println("No moods recorded yet.");
                    }
                    for (Mood moodObj : moodsList) {
                        System.out.println(moodObj);
                    }

                    continue;

                case "w":

                    try (PrintWriter write = new PrintWriter(new FileWriter("moodtracker.txt"))) {
                        for (Mood tempMood : moodsList) {
                            write.println(tempMood + "\n\n");
                        }
                        System.out.println("The entries are written to moodtracker.txt");

                    } catch (IOException e) {
                        System.out.println("Error writing to file " + e.getMessage());
                    }
                    continue;

                case "Exit":
                    System.out.println("Thank you for using the MoodTracker. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Not a valid input!");
                    continue;
            }
        }

        scanner.close();
    }

    public static boolean isMoodValid(Mood mood, ArrayList<Mood> moodsList) throws InvalidMoodException {
        for (Mood tempMood : moodsList) {
            if (tempMood.equals(mood)) {
                throw new InvalidMoodException();
            }
        }
        return true;
    }

    public static boolean deleteMoods(LocalDate date, ArrayList<Mood> moodsList) {
        return moodsList.removeIf(m -> m.getDate().equals(date));
    }

    public static boolean deleteMood(Mood mood, ArrayList<Mood> moodsList) {

        for (Mood tempMood : moodsList) {
            if (tempMood.equals(mood)) {
                moodsList.remove(tempMood);
                return true;
            }
        }
        return false;
    }

    public static boolean editMood(Mood mood, ArrayList<Mood> moodsList) {

        for (Mood tempMood : moodsList) {
            if (tempMood.equals(mood)) {
                tempMood.setNote(mood.getNote());
                return true;
            }
        }
        return false;
    }

    public static void searchMood(LocalDate date, ArrayList<Mood> moodsList) {
        boolean found = false;
        for (Mood tempMood : moodsList) {
            if (tempMood.getDate().equals(date)) {
                System.out.println(tempMood);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not found");
        }
    }

    public static void searchMoods(Mood mood, ArrayList<Mood> moodsList) {
        boolean found = false;
        for (Mood tempMood : moodsList) {
            if (tempMood.equals(mood)) {
                System.out.println(tempMood);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not found");
        }
    }
}
