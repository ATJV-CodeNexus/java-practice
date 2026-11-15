# Directory Explorer

A small interactive program that checks whether a path is a file or a directory and lets you manage it.

## What it does
- Asks for a file or directory path
- **If it is a file:** rename or delete it
- **If it is a directory:** list contents, rename or delete it
- **If it does not exist:** offer to create it as a file (parent folders are created if needed) or as a directory

## Concepts practiced
- `java.io.File`: `exists`, `isFile`, `isDirectory`, `list`, `renameTo`, `delete`, `mkdirs`, `createNewFile`
- Handling `IOException`
- Splitting logic into helper methods

## Files
| File | Purpose |
|---|---|
| `DirectoryExplorer.java` | The whole program |

## Run
```
javac DirectoryExplorer.java
java DirectoryExplorer
```

## Notes
- `File.delete()` only removes empty directories.
- Be careful: this program really deletes things. Try it on a test folder.
