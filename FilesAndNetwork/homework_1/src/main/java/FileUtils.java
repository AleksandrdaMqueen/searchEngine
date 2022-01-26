import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        Long size = 0L;
        Path folder =  Paths.get(path);
        try {
             size = Files.walk(folder)
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .mapToLong(File::length)
                    .sum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }
}
