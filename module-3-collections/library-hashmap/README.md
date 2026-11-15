# Library Management (HashMap, single file)

A library catalog keyed by ISBN, written as one file with `Book` as a nested static class.

## Features
1. Add a book (asks before replacing an existing ISBN)
2. View all books
3. Search by ISBN, title or author
4. Remove a book by ISBN
5. View sorted books (by title or author) using a `TreeMap` with a custom comparator
6. Exit

## Concepts practiced
- `HashMap<String, Book>` with ISBN as key
- Nested static class
- `Map.Entry` iteration
- `TreeMap` with a `Comparator` for sorting a map's keys by a value's field
- Input validation helpers (`isValidName`, `isValidYear`)

## Files
| File | Purpose |
|---|---|
| `LibraryManagementSystem.java` | Everything: `Book`, validation and the menu |

## Run
```
javac LibraryManagementSystem.java
java LibraryManagementSystem
```

## Known limitation
The sorted views use a `TreeMap` whose comparator only looks at title (or author). Two books with the same title (or author) are treated as the same key, so only one of them appears in that sorted view. Fixing this would need a tie-breaker on ISBN or sorting a list of entries instead.
