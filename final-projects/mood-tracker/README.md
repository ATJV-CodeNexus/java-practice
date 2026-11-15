# Mood Tracker

A console app for recording moods with an optional date, time and note.

## Features
- `a` Add a mood (optionally with date and time, plus a note)
- `d` Delete moods (all moods on a date, or one mood by name + date + time)
- `e` Edit the note of a mood
- `s` Search moods (by date, or by name + date + time)
- `M` List all moods
- `w` Write all moods to `moodtracker.txt`
- `Exit` Quit

Date format: `dd/MM/yyyy`. Time format: `HH:mm:ss`.

## Concepts practiced
- Overloaded constructors in `Mood`
- Custom checked exception (`InvalidMoodException`) for duplicate moods
- `equals` based on name (ignoring case), date and time
- `ArrayList` operations, `removeIf`
- Writing to a text file with `PrintWriter` and `FileWriter`
- Parsing dates and times with `DateTimeFormatter`

## Files
| File | Purpose |
|---|---|
| `Mood.java` | Mood model |
| `InvalidMoodException.java` | Thrown when a duplicate mood is added |
| `MoodTracker.java` | Menu and operations |

## Run
```
javac *.java
java MoodTracker
```

## Notes
- If you don't enter a date/time, the date is today and the time is midnight (`00:00`).
- Two moods are the same when name (case-insensitive), date and time match.
