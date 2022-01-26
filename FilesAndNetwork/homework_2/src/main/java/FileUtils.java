import java.io.File;
import java.io.PrintWriter;


public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        try {


            File filesFromSrcDirectory = new File(sourceDirectory);
            File[] files = filesFromSrcDirectory.listFiles();
            PrintWriter printWriter = new PrintWriter(destinationDirectory);

            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()){
                    printWriter.write(files[i].getName());
                }
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
//TODO: write code copy content of sourceDirectory to destinationDirectory;
