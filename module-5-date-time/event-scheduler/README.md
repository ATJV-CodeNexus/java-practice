# Event Scheduler

A console scheduler for events with time zones.

## Features
1. Add an event (name, date, time, time zone, duration)
2. Display all events in a date format pattern you choose
3. Show the time remaining until an event
4. Convert an event's time to another time zone
5. Find upcoming events within the next N days
6. Exit

## Concepts practiced
- `LocalDate`, `LocalTime`, `LocalDateTime`, `ZonedDateTime`, `ZoneId`
- `Duration` (hours, minutes, `toMinutesPart()`)
- `DateTimeFormatter` with custom patterns
- Exception handling for bad dates and numbers

## Files
| File | Purpose |
|---|---|
| `Event.java` | Event model (name, zoned date-time, duration) |
| `EventScheduler.java` | Menu and operations |

## Run
```
javac *.java
java EventScheduler
```

## Input examples
- Date: `2026-12-25`
- Time: `18:30`
- Time zone: `Africa/Luanda`, `Europe/London`, `America/New_York`
- Pattern: `yyyy-MM-dd HH:mm z` or `dd-MMM-yyyy hh:mm a`
