
import java.io.File;
import java.util.ArrayList;

public class Main {

    private static final int newWidth = 300;
    private  static  final String srcFolder = "/users/abake/Desktop/src";
    private  static  final String dstFolder = "/users/abake/Desktop/dst";
    public static void main(String[] args) {
        File srcDir = new File(srcFolder);
        ArrayList<Thread> threads = new ArrayList<>();

        File[] files = srcDir.listFiles();
        int cpuCount = Runtime.getRuntime().availableProcessors();
        int mid = files.length / cpuCount;

        for (int i = 0; i < cpuCount; i++) {

            File[] files1 = new File[files.length - mid * i];
            ImageResizer resizer = new ImageResizer(files1, dstFolder,newWidth);
            threads.add(new Thread(resizer));
        }
        threads.forEach(thread -> {
            thread.start();
            try {

                thread.join();
            }catch (Exception e){
                e.printStackTrace();
            }

        });
        
      


    }
}
