import java.io.File;
import java.util.Scanner;

public class DirectoryRecursiveList {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Press 1 to recursively list a directory and any other key to exit.");

            String userChoice = scanner.nextLine();

            if (userChoice.equals("1")) {
                System.out.println("Enter the directory name: ");
                String fileName = scanner.nextLine();
                File file = new File(fileName);

                if (file.exists() && file.isDirectory()) {
                    recursiveList(file);
                } else {
                    System.out.println("That is not an existing directory.");
                }
            } else {
                System.out.println("Exiting....");
                break;
            }
        }

        scanner.close();
    }

    private static void recursiveList(File dirObj) {

        File[] fileNames = dirObj.listFiles();

        if (fileNames == null) {
            return; // not readable
        }

        for (int i = 0; i < fileNames.length; i++) {
            if (fileNames[i].isFile()) {
                System.out.println(fileNames[i].getAbsoluteFile());
            } else {
                recursiveList(fileNames[i]);
            }
        }
    }
}
