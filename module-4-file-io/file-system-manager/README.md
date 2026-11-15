# File System Manager

A mini command-line shell written in Java. It starts in your home folder and understands a few Unix-style commands.

## Commands
| Command | Action |
|---|---|
| `help` | Show all commands |
| `ls` | List files (type, size, last modified, name) |
| `cd <dir>` | Change directory (`..` goes up) |
| `pwd` | Print current directory |
| `mkdir <name>` | Create a directory |
| `touch <name>` | Create an empty file |
| `rm <name>` | Delete a file or directory (asks before deleting a non-empty directory) |
| `rename <old> <new>` | Rename a file or directory |
| `find <text>` | Recursively find names containing the text |
| `info <name>` | Show size, permissions, path, etc. |
| `exit` | Quit |

## Concepts practiced
- Object-oriented design with instance fields (`currentDirectory`, `scanner`)
- Command parsing with `split` and `switch`
- Recursion (`findFilesRecursively`, `deleteRecursively`)
- `SimpleDateFormat`, `printf`

## Files
| File | Purpose |
|---|---|
| `FileSystemManager.java` | The whole program |

## Run
```
javac FileSystemManager.java
java FileSystemManager
```

## Notes
- Paths with spaces work for `mkdir`, `touch`, `rm`, `cd`, `find` and `info`. For `rename`, the first name cannot contain spaces.
- `rm` on a non-empty directory deletes everything inside it after you confirm with `y`. Test in a throwaway folder first.
