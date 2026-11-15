# Music Shop (Inheritance, Abstract Classes, Interfaces)

A small instrument hierarchy showing abstraction, inheritance, multiple interface implementation and polymorphism.

## Class design
- `Instrument` (abstract): name, year, abstract `play()`
- `StringedInstrument` extends `Instrument`: adds number of strings
- `Guitar` extends `StringedInstrument`, implements `Tunable`, `Maintainable`
- `Piano` extends `Instrument`, implements `Tunable`, `Maintainable`
- `Tunable` interface: `tune()`, `adjustPitch(boolean)`
- `Maintainable` interface: `clean()`, `inspect()`

## Concepts practiced
- Abstract classes and abstract methods
- Method overriding and `super` calls
- Implementing multiple interfaces
- Polymorphism: one `Instrument[]` array holding different types
- `instanceof` checks and casting to interfaces

## Files
| File | Purpose |
|---|---|
| `Instrument.java` | All the instrument classes and interfaces (non-public, one file) |
| `MusicShop.java` | Main program: plays and maintains the instruments |

## Run
```
javac *.java
java MusicShop
```
