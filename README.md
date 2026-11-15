# Java Practice

A collection of Java programs and projects written while learning core Java, organized by module. Every project is a console application with its own README explaining what it does and how to run it.

## Contents

| Module | Project | Topics |
|---|---|---|
| 1. Encapsulation | [Employee Management](module-1-encapsulation/employee-management) | Private fields, validation in setters, constructors, `Cloneable` |
| 2. Inheritance & Polymorphism | [Music Shop](module-2-inheritance-polymorphism/music-shop) | Abstract classes, interfaces, polymorphism, `instanceof` |
| 3. Collections | [Library (ArrayList)](module-3-collections/library-arraylist) | `ArrayList`, `Comparator`, `Collections.sort` |
| 3. Collections | [Library (HashMap)](module-3-collections/library-hashmap) | `HashMap`, `TreeMap`, nested classes |
| 3. Collections | [Phone Book](module-3-collections/phonebook-hashmap) | `HashMap`, regex validation |
| 4. File I/O | [Directory Explorer](module-4-file-io/directory-explorer) | `File`, create / rename / delete |
| 4. File I/O | [Recursive Directory List](module-4-file-io/directory-recursive-list) | Recursion over directories |
| 4. File I/O | [File System Manager](module-4-file-io/file-system-manager) | Mini shell: `ls`, `cd`, `mkdir`, `rm`, `find`... |
| 5. Date & Time | [Event Scheduler](module-5-date-time/event-scheduler) | `ZonedDateTime`, `Duration`, time zones |
| 5. Date & Time | [Travel Planner](module-5-date-time/travel-planner) | `LocalDate`, `ChronoUnit`, validation |
| 5. Date & Time | [Date/Time Operations](module-5-date-time/datetime-operations) | Add/subtract time, custom formats |
| 5. Date & Time | [Date Difference Calculator](module-5-date-time/date-difference-calculator) | `Period` vs `ChronoUnit` |
| Final | [Mood Tracker](final-projects/mood-tracker) | Custom exception, overloaded constructors, file writing |
| Final | [Pet Care Scheduler](final-projects/pet-care-scheduler) | Serialization, appointments, reports |
| Final | [Eco-Points Recycling Tracker](final-projects/eco-points-recycling-tracker) | Serialization, object relationships |

## How to run any project

Requires JDK 11 or newer.

```
cd path/to/project-folder
javac *.java
java MainClassName
```

The main class name is listed in each project's README.
