import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EcoPointsRecyclingTracker {

    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Household> households = new HashMap<>();

    public static void main(String[] args) {
        loadHouseholdsFromFile();
        boolean running = true;
        while (running) {
            System.out.println("\n=== Eco-Points Recycling Tracker ===\n" +
                    "\n" +
                    "1. Register Household\n" +
                    "2. Log Recycling Event\n" +
                    "3. Display Households\n" +
                    "4. Display Household Recycling Events\n" +
                    "5. Generate Reports\n" +
                    "6. Save and Exit\n" +
                    "Enter your choice: ");

            String userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1":
                    registerHousehold();
                    break;
                case "2":
                    logRecyclingEvent();
                    break;
                case "3":
                    displayHouseholds();
                    break;
                case "4":
                    displayHouseholdEvents();
                    break;
                case "5":
                    generateReports();
                    break;
                case "6":
                    saveHouseholdsToFile();
                    running = false;
                    System.out.println("Data saved. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input, please enter 1-6");
            }
        }
    }

    private static void registerHousehold() {
        System.out.println("Enter the household id: ");
        String id = scanner.nextLine().trim();

        if (households.containsKey(id)) {
            System.out.println("A household with this id already exists");
            return;
        }

        System.out.println("Enter the household name: ");
        String name = scanner.nextLine();

        System.out.println("Enter the household address:");
        String address = scanner.nextLine();

        Household house = new Household(id, name, address);
        households.put(id, house);

        System.out.println("Household successfully added");
    }

    private static void logRecyclingEvent() {

        System.out.println("Enter the id of the household");
        String id = scanner.nextLine().trim();

        Household household = households.get(id);

        if (household == null) {
            System.out.println("There is no household with that id");
            return;
        }

        System.out.println("Please enter the type of material.");
        String material = scanner.nextLine().trim();

        double weight;

        try {
            System.out.println("Please enter the weight in kilograms");
            weight = Double.parseDouble(scanner.nextLine());

            if (weight <= 0) {
                System.out.println("Weight must be greater than 0.");
                return;
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input: please enter a number.");
            return;
        }

        RecyclingEvent event = new RecyclingEvent(material, weight);

        household.addEvent(event);

        System.out.println("Event successfully added to " + household.getName());
        System.out.println("Eco points earned: " + event.getEcoPoints());
    }

    private static void displayHouseholds() {

        if (households.isEmpty()) {
            System.out.println("No households registered yet");
            return;
        }

        for (Household h : households.values()) {
            System.out.println("ID: " + h.getId() +
                    ", Name: " + h.getName() +
                    ", Address: " + h.getAddress() +
                    ", Joined: " + h.getJoinDate());
        }
    }

    private static void displayHouseholdEvents() {
        if (households.isEmpty()) {
            System.out.println("No households registered yet");
            return;
        }

        System.out.println("Enter the id of the household: ");
        String id = scanner.nextLine().trim();

        Household household = households.get(id);

        if (household == null) {
            System.out.println("There is no household with that id");
            return;
        }

        if (household.getEvents().isEmpty()) {
            System.out.println("Currently there is no event for this household");
            return;
        }

        System.out.println("All household events: \n");
        for (RecyclingEvent event : household.getEvents()) {
            System.out.println(event);
        }

        System.out.println("Total weight for this household: " + household.getTotalWeight() + " kg");
        System.out.println("Total points for this household: " + household.getTotalPoints());
    }

    private static void generateReports() {

        if (households.isEmpty()) {
            System.out.println("Households list is empty");
            return;
        }

        Household top = null;
        for (Household h : households.values()) {
            if (top == null || h.getTotalPoints() > top.getTotalPoints()) {
                top = h;
            }
        }
        System.out.println("\nHousehold with Highest Points:");
        System.out.println("ID: " + top.getId() +
                ", Name: " + top.getName() +
                ", Points: " + top.getTotalPoints());

        double totalWeight = 0.0;

        for (Household household : households.values()) {
            totalWeight += household.getTotalWeight();
        }

        System.out.println("Total Community Recycling Weight: " + totalWeight + " kg");
    }

    private static void saveHouseholdsToFile() {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("households.ser"))) {

            out.writeObject(households);

            System.out.println("File saved successfully");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadHouseholdsFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("households.ser"))) {

            households = (Map<String, Household>) in.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("No saved data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
