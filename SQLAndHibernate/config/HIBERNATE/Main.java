import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();

        Session session = factory.openSession();
        System.out.println("Введите id курса: ");
        Scanner scanner = new Scanner(System.in);

        int id = scanner.nextInt();

        Course course = session.get(Course.class,  id);
        System.out.println(course);

    }

}
