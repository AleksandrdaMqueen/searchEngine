import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        try {


            File filesFromSrcDirectory = new File(sourceDirectory);
            File[] files = filesFromSrcDirectory.listFiles();
            Path dest = Paths.get(destinationDirectory);

            for (File file : files){
                Files.copy(file.toPath(),dest.resolve(file.getName()) , StandardCopyOption.REPLACE_EXISTING);
                if (file.isDirectory()){
                    File folder = new File(file.getAbsolutePath());
                    File[] files1 = folder.listFiles();
                    for (File file1 : files1){
                        Files.copy(file1.toPath(),dest.resolve(file1.getName()) , StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
//TODO: write code copy content of sourceDirectory to destinationDirectory;
