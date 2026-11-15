# Recursive Directory List

Prints the absolute path of every file inside a directory and all of its sub-directories.

## What it does
- Press `1`, then type a directory path
- The program recurses into every sub-directory and prints each file's absolute path
- Any other key exits

## Concepts practiced
- Recursion
- `File.listFiles()`, `isFile()`, `isDirectory()`, `getAbsoluteFile()`

## Files
| File | Purpose |
|---|---|
| `DirectoryRecursiveList.java` | The whole program |

## Run
```
javac DirectoryRecursiveList.java
java DirectoryRecursiveList
```

## Notes
- If the path is not an existing directory, a message is shown.
- Folders you have no permission to read are skipped (`listFiles()` returns `null`).
