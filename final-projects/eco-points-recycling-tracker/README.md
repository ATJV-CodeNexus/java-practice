# Eco-Points Recycling Tracker

A console app where households log recycling events and earn eco-points (10 points per kg). Data is saved to disk with Java serialization.

## Features
1. Register a household (id, name, address)
2. Log a recycling event (material type and weight in kg)
3. Display all households
4. Display one household's recycling events, total weight and total points
5. Generate reports: household with the highest points, and total community weight
6. Save and exit

Data is loaded automatically from `households.ser` at startup.

## Concepts practiced
- Object relationships (`Household` has many `RecyclingEvent`s)
- `Serializable` and file persistence
- `HashMap<String, Household>`
- Aggregating data (totals, maximum)
- Input validation with exceptions

## Files
| File | Purpose |
|---|---|
| `RecyclingEvent.java` | One recycling event: material, weight, date, points |
| `Household.java` | Household with its events and running point total |
| `EcoPointsRecyclingTracker.java` | Menu, persistence and reports |

## Run
```
javac *.java
java EcoPointsRecyclingTracker
```

## Notes
- Eco-points = weight in kg x 10.
- Only option 6 saves the data. Closing the window without choosing it loses the session's changes.
- If you change the fields of the model classes, delete the old `households.ser`.
