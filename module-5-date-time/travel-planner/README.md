# Travel Planner

A console tool for planning trips with date calculations and checks.

## Features
1. Calculate trip duration (days)
2. Validate travel dates
3. Calculate hotel check-in and check-out
4. Check if the trip overlaps with a holiday
5. Exit

All dates use the format `dd/MM/yyyy`.

## Validation rules
- Departure cannot be in the past
- Return must be after departure
- A trip cannot be longer than 90 days

## Concepts practiced
- `LocalDate`, `DateTimeFormatter`, `ChronoUnit.DAYS.between`
- Date comparisons: `isBefore`, `isAfter`, `isEqual`
- Static helper methods and a `static final` constant
- `DateTimeParseException` handling

## Files
| File | Purpose |
|---|---|
| `TravelPlanner.java` | The whole program |

## Run
```
javac TravelPlanner.java
java TravelPlanner
```
