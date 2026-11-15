# Pet Care Scheduler

A console app for registering pets, scheduling appointments, viewing history and generating reports. Data is saved to disk with Java serialization.

## Features
1. Register a pet (id, name, species, age, owner, contact)
2. Schedule an appointment (purpose, date, time, optional note)
3. Display pets and their past and/or upcoming appointments
4. Generate a report:
   - Pets with an appointment in the next 7 days
   - Pets with no "visit" in the past 6 months
5. Save pet data to `pet.ser`
6. Exit

Data is loaded automatically from `pet.ser` at startup.

Date format: `dd/MM/yyyy`. Time format: `HH:mm:ss`.

## Concepts practiced
- `Serializable` objects and `ObjectOutputStream` / `ObjectInputStream`
- Objects containing lists of other objects (`Pet` has `Appointment`s)
- `HashMap<String, Pet>` keyed by id
- `LocalDateTime` comparisons
- try-with-resources

## Files
| File | Purpose |
|---|---|
| `Appointment.java` | Appointment model (type, date-time, note) |
| `Pet.java` | Pet model with its appointment list |
| `PetCareScheduler.java` | Menu, persistence and reports |

## Run
```
javac *.java
java PetCareScheduler
```

## Notes
- Appointments in the past cannot be scheduled.
- Choose option 5 to save before exiting. Exiting does not save automatically.
- If you change the fields of `Pet` or `Appointment`, delete the old `pet.ser`, because old saved data may no longer load.
