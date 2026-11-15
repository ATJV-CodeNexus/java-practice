import java.io.Serializable;
import java.time.LocalDateTime;


public class Appointment implements Serializable{

    private String type;
    private LocalDateTime dateTime;
    private String note;

    public Appointment(String type, LocalDateTime dateTime, String note){
        this.type = type;
        this.dateTime = dateTime;
        this.note = note;
    }

    public Appointment(String type, LocalDateTime dateTime){
        this.type = type;
        this.dateTime = dateTime;
    }

    public String getType(){
        return this.type;
    }
    public LocalDateTime getDateTime(){
        return this.dateTime;
    }
    public String getNote(){
        return this.note;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "type='" + type + '\'' +
                ", dateTime=" + dateTime +
                ", note='" + note + '\'' +
                '}';
    }
}
