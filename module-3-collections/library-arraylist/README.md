# Library Management (ArrayList)

A menu-driven console library system built on an `ArrayList<Book>` with a separate `Book` class.

## Features
1. Add a book
2. View all books
3. Search by title or author (case-insensitive)
4. Check out a book
5. Return a book
6. Sort by title, author or publication year
7. View available books only
8. Exit

## Concepts practiced
- `ArrayList` of custom objects
- Separate model class (`Book`) with encapsulation
- `Comparator` (anonymous classes) with `Collections.sort`
- Input validation with `try/catch` for `NumberFormatException`
- Helper methods to keep `main` clean

## Files
| File | Purpose |
|---|---|
| `Book.java` | Book model: title, author, year, availability |
| `LibraryManagement.java` | Menu and all library operations |

## Run
```
javac *.java
java LibraryManagement
```

The program starts with three sample books.
