import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    private static final int newWidth = 300;
    private  static  final String srcFolder = "/users/abake/Desktop/src";
    private  static  final String dstFolder = "/users/abake/Desktop/dst";
    public static void main(String[] args) {
        File srcDir = new File(srcFolder);

        File[] files = srcDir.listFiles();
        int mid = files.length / 8;
        
        File[] files1 = new File[files.length - mid];
        System.arraycopy(files, 0 ,files1,0,files1.length);
        ImageResizer resizer = new ImageResizer(files1,dstFolder,newWidth);
        resizer.start();

        File[] files2 = new File[files1.length - mid];
        System.arraycopy(files, 0 ,files2,0,files2.length);
        ImageResizer resizer1 = new ImageResizer(files2,dstFolder,newWidth);
        resizer1.start();

        File[] files3 = new File[files2.length - mid];
        System.arraycopy(files, 0 ,files3,0,files3.length);
        ImageResizer resizer2 = new ImageResizer(files3,dstFolder,newWidth);
        resizer2.start();

        File[] files4 = new File[files3.length - mid];
        System.arraycopy(files, 0 ,files4,0,files4.length);
        ImageResizer resizer3 = new ImageResizer(files4,dstFolder,newWidth);
        resizer3.start();

        File[] files5 = new File[files4.length - mid];
        System.arraycopy(files, 0 ,files5,0,files5.length);
        ImageResizer resizer4 = new ImageResizer(files5,dstFolder,newWidth);
        resizer4.start();

        File[] files6 = new File[files5.length - mid];
        System.arraycopy(files, 0 ,files6,0,files6.length);
        ImageResizer resizer5 = new ImageResizer(files6,dstFolder,newWidth);
        resizer5.start();

        File[] files7 = new File[files6.length - mid];
        System.arraycopy(files, 0 ,files7,0,files7.length);
        ImageResizer resizer6 = new ImageResizer(files7,dstFolder,newWidth);
        resizer6.start();


    }
}
