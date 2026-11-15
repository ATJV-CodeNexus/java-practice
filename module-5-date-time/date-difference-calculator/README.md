# Date Difference Calculator

Two small programs that calculate the difference between two dates, using two different Java APIs.

| Program | API | Output |
|---|---|---|
| `DateDiffCalculator2` | `Period` | Difference as years, months and days |
| `DateDiffCalChrono` | `ChronoUnit.DAYS.between` | Difference as total days |

## How they work
1. Enter the date pattern you want to use (for example `dd/MM/yyyy`)
2. Enter two dates in that pattern
3. The program prints both dates and the difference

## Concepts practiced
- `Period` vs `ChronoUnit`
- `DateTimeFormatter.ofPattern` with a user-supplied pattern
- `LocalDate.parse`, `isBefore`, `isEqual`
- Catching `DateTimeParseException`

## Run
```
javac *.java
java DateDiffCalculator2
java DateDiffCalChrono
```

## Note
`DateDiffCalChrono` can print a negative number if the first date is later than the second. `DateDiffCalculator2` always orders the dates first.
