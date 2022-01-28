public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        try {


            Files.walk(Paths.get(sourceDirectory))
                    .forEach(source -> {
                        Path destination = Paths.get(destinationDirectory, source.toString()
                                .substring(sourceDirectory.length()));
                        try {
                            Files.copy(source, destination);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
//TODO: write code copy content of sourceDirectory to destinationDirectory;
