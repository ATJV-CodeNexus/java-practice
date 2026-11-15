import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PhoneBookHashMap {

    private static boolean isNameValid(String name) {
        if (name.matches("^[a-zA-Z' -]+$")) {
            return true;
        }
        System.out.println("Invalid name!");
        return false;
    }

    private static boolean isNumberValid(String number) {
        if (number.matches("\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}")) {
            return true;
        }
        System.out.println("Invalid number!");
        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> phoneBook = new HashMap<>();

        try {

            boolean running = true;
            while (running) {

                System.out.println(
                        "Press 1 to add an entry in the phonebook," +
                                "\n2 to view all the entries" +
                                "\n3 to search for entries with name" +
                                "\n4 to delete an entry" +
                                "\n5 to sort the entries by name" +
                                "\nAny other key to exit");

                String userInput = scanner.nextLine();

                if (userInput.equals("1")) {

                    System.out.println("Please enter the name you want: ");
                    String name = scanner.nextLine();

                    if (!isNameValid(name)) {
                        continue;
                    }
                    if (phoneBook.containsKey(name)) {
                        System.out.println("Name already exists in the phone book. Do you want to replace it? y/n");

                        String repChoice = scanner.nextLine();

                        if (repChoice.equalsIgnoreCase("n")) {
                            continue;
                        }
                    }

                    System.out.println("Please add the phone number that you want: ");
                    String phoneNumber = scanner.nextLine();

                    if (!isNumberValid(phoneNumber)) {
                        continue;
                    }

                    phoneBook.put(name, phoneNumber);
                    System.out.println("The name and number have been added to the phonebook.");

                } else if (userInput.equals("2")) {

                    for (String name : phoneBook.keySet()) {
                        System.out.println(name + ": " + phoneBook.get(name));
                    }

                } else if (userInput.equals("3")) {
                    System.out.println("Enter the name that you are looking for: ");
                    String keyName = scanner.nextLine();

                    if (phoneBook.containsKey(keyName)) {
                        System.out.println("The phone number that you are looking for is: " + phoneBook.get(keyName));
                    } else {
                        System.out.println("No such name found in the phonebook.");
                    }

                } else if (userInput.equals("4")) {
                    System.out.println("Enter the name that you want to delete: ");
                    String keyName = scanner.nextLine();

                    if (phoneBook.containsKey(keyName)) {
                        phoneBook.remove(keyName);
                        System.out.println("The name " + keyName + " is deleted.");
                    } else {
                        System.out.println("No such name found in the phonebook.");
                    }

                } else if (userInput.equals("5")) {

                    TreeMap<String, String> phoneBookTree = new TreeMap<>(phoneBook);

                    for (Map.Entry<String, String> entry : phoneBookTree.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }

                } else {
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        scanner.close();
    }
}
