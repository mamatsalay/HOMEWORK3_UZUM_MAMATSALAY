import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SizeFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import java.io.File;
import java.util.Collection;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        long sizeThreshold = 10 * 1024 * 1024;

        String folderPath = getValidPath(scanner);

        File directory = new File(folderPath);

        Collection<File> largeFiles = FileUtils.listFiles(
                directory,
                new SizeFileFilter(sizeThreshold, true),
                TrueFileFilter.INSTANCE
        );

        if (largeFiles.isEmpty()) {
            System.out.println("No files larger than 10MB found.");
        } else {
            System.out.println("Files larger than 10MB found:");
            for (File file : largeFiles) {
                double fileSize = Math.round(((double) FileUtils.sizeOf(file) /1048576));
                System.out.println(file.getName() + " size: " + fileSize + "MB");
            }
        }

        scanner.close();
    }

    private static String getValidPath(Scanner scanner) {
        String folderPath;
        do {
            System.out.println("Enter folder path: ");
            folderPath = scanner.nextLine();
            File directory = new File(folderPath);
            if (!directory.exists()) {
                System.out.println("Error: Directory not found. Please try again.");
            }
        } while (!new File(folderPath).exists());

        return folderPath;
    }
}