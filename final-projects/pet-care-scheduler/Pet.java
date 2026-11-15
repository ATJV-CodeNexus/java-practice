import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pet implements Serializable {

    private String id;
    private String petName;
    private String species;
    private int age;
    private String ownerName;
    private String contactInfo;
    private LocalDate registrationDate;
    private List<Appointment> appointments;

    public Pet(String id, String petName, String species, int age, String ownerName, String contactInfo) {
        this.id = id;
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.ownerName = ownerName;
        this.contactInfo = contactInfo;
        this.registrationDate = LocalDate.now();
        this.appointments = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public String getPetName() {
        return this.petName;
    }

    public String getSpecies() {
        return this.species;
    }

    public int getAge() {
        return this.age;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public String getContactInfo() {
        return this.contactInfo;
    }

    public LocalDate getRegistrationDate() {
        return this.registrationDate;
    }

    public List<Appointment> getAppointments() {
        return this.appointments;
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    public void getAppointmentHistory() {
        LocalDateTime now = LocalDateTime.now();
        for (Appointment app : appointments) {
            if (app.getDateTime().isBefore(now)) {
                System.out.println("Past: " + app);
            }
        }
    }

    public void getUpcomingAppointments() {
        LocalDateTime now = LocalDateTime.now();
        for (Appointment app : appointments) {
            if (app.getDateTime().isAfter(now)) {
                System.out.println("Future: " + app);
            }
        }
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id='" + id + '\'' +
                ", petName='" + petName + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                ", ownerName='" + ownerName + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", registrationDate=" + registrationDate +
                ", appointments=" + appointments +
                '}';
    }
}
