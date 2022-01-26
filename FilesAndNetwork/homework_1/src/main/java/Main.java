import java.io.File;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        while (true){
            System.out.println("Выберите одну из комнад: ");

            TreeSet<String> commands = new TreeSet<>(){{
                add("Узнать размер");
                add("Узнать путь");
            }};
            System.out.println("Выберите одну из комнад: ");

            commands.forEach(System.out::println);

            Scanner scanner = new Scanner(System.in);

            String command = scanner.nextLine();


            if (command.equals("Узнать размер")){
                System.out.println("Укажите путь до этой папки: ");
                Scanner scanner1 = new Scanner(System.in);
                String path = scanner.nextLine();
                System.out.println(FileUtils.calculateFolderSize(path) + " байт");
            }else if (command.equals("Узнать путь")){
                System.out.println("Укажите имя папки: ");
                Scanner scanner1 = new Scanner(System.in);
                File file = new File(scanner1.nextLine());
                System.out.println(getPath(file));
            }


        }
    }

    private static String getPath(File file){
        String path = file.getAbsolutePath();

        return path;
    }




}
