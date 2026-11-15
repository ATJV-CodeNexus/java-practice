# Phone Book (HashMap)

A console phone book that stores names and numbers in a `HashMap`, with regex validation.

## Features
1. Add an entry (asks before replacing an existing name)
2. View all entries
3. Search by name
4. Delete an entry
5. View entries sorted by name (via `TreeMap`)
- Any other key exits

## Concepts practiced
- `HashMap<String, String>` and `TreeMap` for sorted output
- Regular expressions with `String.matches`
- Validation helper methods

## Validation
- **Name:** letters, spaces, apostrophes and hyphens only
- **Number:** optional `+`, country code, area code and digits, with optional `-`, `.` or space separators

## Files
| File | Purpose |
|---|---|
| `PhoneBookHashMap.java` | The whole program |

## Run
```
javac PhoneBookHashMap.java
java PhoneBookHashMap
```

## Note
Names are case-sensitive: "Ann" and "ann" are different entries.
