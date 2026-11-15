# Date/Time Operations

Shows the current date and time, lets you add or subtract units of time, and converts to other time zones.

## Features
1. Add or subtract days, months, years, hours, minutes, seconds or weeks from the current date/time, then print it in a format you choose
2. Convert the current date/time to any time zone (lists all available zone IDs first)
- Any other key exits

## Concepts practiced
- `ZonedDateTime.now()`, `plusX()` and `minusX()` methods
- `withZoneSameInstant`
- `ZoneId.getAvailableZoneIds()`
- `DateTimeFormatter.ofPattern` with user-supplied patterns

## Files
| File | Purpose |
|---|---|
| `DateTimeOperations.java` | The whole program |

## Run
```
javac DateTimeOperations.java
java DateTimeOperations
```

## Input examples
- Unit codes: `d` days, `M` months, `y` years, `h` hours, `m` minutes, `s` seconds, `w` weeks
- Format: `dd/MM/yyyy HH:mm:ss`
- Zone: `Africa/Luanda`, `Asia/Tokyo`
