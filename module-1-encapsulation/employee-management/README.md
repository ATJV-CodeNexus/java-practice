# Employee Management (Encapsulation)

Demonstrates encapsulation: private fields, validated setters, constructors, and object cloning.

## Concepts practiced
- Private fields with public getters/setters
- Validation inside setters (invalid values fall back to defaults)
- Default and parameterized constructors
- `Cloneable` and `clone()`
- Static helper method (`compareSalaries`)

## Files
| File | Purpose |
|---|---|
| `Employee.java` | The `Employee` class (name, age, salary) |
| `TestEncapsulation.java` | Main program that tests validation, raises and cloning |

## Validation rules
- Name: not null and not empty, otherwise `"Unknown"`
- Age: 18 to 65, otherwise `18`
- Salary: not negative, otherwise `0`

## Run
```
javac *.java
java TestEncapsulation
```

## Notes
- `giveRaise` uses `percentage / 100.0` so that the division is not an integer division.
- `clone()` is shallow, which is fine here because all fields are primitives or immutable `String`s.
