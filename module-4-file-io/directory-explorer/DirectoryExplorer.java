import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DirectoryExplorer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Enter the file name or the directory name:");
            String fileName = scanner.nextLine();

            File file = new File(fileName);

            if (file.exists()) {
                if (file.isFile()) {
                    System.out.println("It is a file.");
                    fileManagement(file, scanner);
                } else if (file.isDirectory()) {
                    System.out.println("It is a directory.");
                    directoryManagement(file, scanner);
                }
            } else {
                System.out.println("No file or directory is found with the name " + file);
                System.out.println("To create a file with the given name press 1\n"
                        + "To create a directory with the given name press 2\n"
                        + "To exit press any other key.");

                String userInput = scanner.nextLine();

                if (userInput.equals("1")) {
                    File parent = file.getParentFile();

                    if (parent != null && !parent.exists()) {
                        boolean created = parent.mkdirs();
                        if (!created) {
                            System.out.println("Couldn't create the parent folders!");
                            continue;
                        }
                    }

                    try {
                        file.createNewFile();
                        System.out.println("File created successfully!");
                    } catch (IOException ioe) {
                        System.out.println("Error occurred: " + ioe.getMessage());
                    }
                } else if (userInput.equals("2")) {
                    boolean created = file.mkdirs();
                    if (created) {
                        System.out.println("Directory created successfully!");
                    } else {
                        System.out.println("Couldn't create directory.");
                    }
                } else {
                    System.out.println("Exiting.....");
                    break;
                }
            }
        }
        scanner.close();
    }

    private static void fileManagement(File myFile, Scanner scanner) {
        System.out.println("Press 1 to rename the file\nPress 2 to delete the file\nAny other key to exit");

        String userChoice = scanner.nextLine();
        if (userChoice.equals("1")) {
            System.out.println("Enter the new name for the file: ");
            String newFileName = scanner.nextLine();
            File renamedFile = new File(myFile.getParent(), newFileName);
            boolean renamed = myFile.renameTo(renamedFile);
            if (renamed) {
                System.out.println("File renamed to " + renamedFile + " successfully.");
            } else {
                System.out.println("Couldn't rename file.");
            }
        } else if (userChoice.equals("2")) {
            boolean deleted = myFile.delete();
            if (deleted) {
                System.out.println("File deleted");
            } else {
                System.out.println("Couldn't delete file.");
            }
        } else {
            System.out.println("Exiting.....");
        }
    }

    private static void directoryManagement(File dirObj, Scanner scanner) {
        System.out.println("Press 1 to list the files in the directory\nPress 2 to rename the directory\n"
                + "Press 3 to delete the directory\nAny other key to exit.");

        String userChoice = scanner.nextLine();
        if (userChoice.equals("1")) {
            String[] fileNames = dirObj.list();

            if (fileNames == null || fileNames.length == 0) {
                System.out.println("Directory is empty.");
                return;
            }

            System.out.println("File names inside the directory:");
            for (int i = 0; i < fileNames.length; i++) {
                System.out.println((i + 1) + ". " + fileNames[i]);
            }

        } else if (userChoice.equals("2")) {

            System.out.println("Enter the new name for the directory: ");
            String newDirName = scanner.nextLine();
            boolean renamed = dirObj.renameTo(new File(dirObj.getParent(), newDirName));

            if (renamed) {
                System.out.println("Directory renamed successfully.");
            } else {
                System.out.println("Couldn't rename directory");
            }
        } else if (userChoice.equals("3")) {

            boolean deleted = dirObj.delete();
            if (deleted) {
                System.out.println("Directory deleted");
            } else {
                System.out.println("Directory could not be deleted (it must be empty).");
            }

        } else {
            System.out.println("Exiting.....");
        }
    }
}
