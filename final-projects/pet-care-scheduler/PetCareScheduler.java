import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PetCareScheduler {

    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Pet> pets = new HashMap<>();

    public static void main(String[] args) {
        loadFromFile();
        boolean running = true;
        while (running) {
            System.out.println("-press 1 to register a pet \n" +
                    "-press 2 to schedule an appointment \n" +
                    "-press 3 to display the list of appointments (past or future) \n" +
                    "-press 4 to generate report of the pets\n" +
                    "-press 5 to save pet data into a file \n" +
                    "-press 6 to exit. \n" +
                    "-choose 1-6  : \n");

            String userChoice = scanner.nextLine().trim();

            switch (userChoice) {
                case "1":
                    addPet();
                    break;
                case "2":
                    scheduleAppointment();
                    break;
                case "3":
                    displayAppointments();
                    break;
                case "4":
                    generateReport();
                    break;
                case "5":
                    saveToFile();
                    break;
                case "6":
                    running = false;
                    System.out.println("Thank you, bye!!");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private static void addPet() {
        System.out.println("Please enter the id for the new pet: ");
        String id = scanner.nextLine().trim();

        if (pets.containsKey(id)) {
            System.out.println("This id is already registered");
            return;
        }
        System.out.println("Please enter the name of the pet: ");
        String petName = scanner.nextLine().trim();

        System.out.println("Please enter the species of the pet: ");
        String species = scanner.nextLine().trim();

        System.out.println("Please enter the age of the pet: ");
        int age = 0;
        boolean valid = false;
        while (!valid) {
            try {
                age = Integer.parseInt(scanner.nextLine().trim());
                if (age <= 0) {
                    System.out.println("Age must be greater than 0");
                } else {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
            }
        }

        System.out.println("Please enter the name of the pet owner: ");
        String ownerName = scanner.nextLine().trim();

        System.out.println("Please enter the contact information: ");
        String info = scanner.nextLine().trim();

        Pet pet = new Pet(id, petName, species, age, ownerName, info);
        pets.put(id, pet);

        System.out.println("Pet successfully added");
    }

    private static void scheduleAppointment() {

        System.out.println("Enter the id of the pet: ");
        String id = scanner.nextLine().trim();

        Pet pet = pets.get(id);

        if (pet == null) {
            System.out.println("There is no pet registered with this id.");
            return;
        }

        System.out.println("Enter the purpose of your appointment (visit, vaccination, grooming): ");
        String visitType = scanner.nextLine().trim();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTime;
        try {
            System.out.println("Enter the date of appointment in dd/MM/yyyy format");
            String strDate = scanner.nextLine().trim();
            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(strDate, formatDate);

            System.out.println("Enter the time of appointment in HH:mm:ss format");
            String strTime = scanner.nextLine().trim();
            DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime time = LocalTime.parse(strTime, formatTime);

            dateTime = LocalDateTime.of(date, time);

            if (dateTime.isBefore(now)) {
                System.out.println("Appointment cannot be made in the past");
                return;
            }

        } catch (DateTimeParseException dfe) {
            System.out.println("Invalid input: " + dfe.getMessage());
            return;
        }

        System.out.println("Enter additional note: ");
        String note = scanner.nextLine().trim();

        Appointment appointment;
        if (note.isEmpty()) {
            appointment = new Appointment(visitType, dateTime);
        } else {
            appointment = new Appointment(visitType, dateTime, note);
        }

        pet.addAppointment(appointment);

        System.out.println("Appointment successfully added");
    }

    private static void printPetInfo(Pet pet) {
        System.out.println("- Id: " + pet.getId()
                + " - name: " + pet.getPetName()
                + " - species: " + pet.getSpecies()
                + " - age: " + pet.getAge()
                + " - owner name: " + pet.getOwnerName()
                + " - contact info: " + pet.getContactInfo()
                + " - registration date: " + pet.getRegistrationDate());
    }

    private static Pet askForPet() {
        System.out.println("Enter the id of the pet: ");
        String id = scanner.nextLine().trim();

        Pet pet = pets.get(id);

        if (pet == null) {
            System.out.println("There is no pet registered with this id.");
        }
        return pet;
    }

    private static void displayAppointments() {
        if (pets.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("List of pets\n");
        for (Pet pet : pets.values()) {
            printPetInfo(pet);
        }

        System.out.println("Press p to see past appointments,\n" +
                "f to see future appointments,\n" +
                "or a to see past and future appointments of a pet.");

        String choice = scanner.nextLine().trim();

        if (choice.equalsIgnoreCase("p")) {

            Pet pet = askForPet();
            if (pet == null) {
                return;
            }

            System.out.println("List of past pet appointments\n");
            printPetInfo(pet);
            pet.getAppointmentHistory();

        } else if (choice.equalsIgnoreCase("f")) {

            Pet pet = askForPet();
            if (pet == null) {
                return;
            }

            System.out.println("List of future pet appointments\n");
            printPetInfo(pet);
            pet.getUpcomingAppointments();

        } else if (choice.equalsIgnoreCase("a")) {

            Pet pet = askForPet();
            if (pet == null) {
                return;
            }

            System.out.println("List of past and future pet appointments\n");
            printPetInfo(pet);
            pet.getAppointmentHistory();
            System.out.println();
            pet.getUpcomingAppointments();

        } else {
            System.out.println("Invalid input");
        }
    }

    private static void generateReport() {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneWeekFromNow = now.plusDays(7);

        System.out.println("Appointments in the next 7 days:\n");
        for (Pet pet : pets.values()) {

            for (Appointment appointment : pet.getAppointments()) {

                LocalDateTime appointmentDate = appointment.getDateTime();

                if (appointmentDate.isAfter(now) && !appointmentDate.isAfter(oneWeekFromNow)) {
                    System.out.println(pet.getPetName() + ": " + appointment);
                    break;
                }
            }
        }

        LocalDateTime beforeSixMonths = now.minusMonths(6);
        System.out.println("\nPets that didn't get visited in the past 6 months:");

        for (Pet pet : pets.values()) {
            boolean recentVisit = false;

            for (Appointment appointment : pet.getAppointments()) {

                String purpose = appointment.getType();
                LocalDateTime visitDate = appointment.getDateTime();

                if (purpose.equalsIgnoreCase("visit")) {
                    if (visitDate.isAfter(beforeSixMonths) && !visitDate.isAfter(now)) {
                        recentVisit = true;
                        break;
                    }
                }
            }

            if (!recentVisit) {
                System.out.println(pet);
            }
        }
    }

    private static void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pet.ser"))) {

            out.writeObject(pets);

            System.out.println("File saved successfully");

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("pet.ser"))) {

            pets = (Map<String, Pet>) in.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("No saved data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
