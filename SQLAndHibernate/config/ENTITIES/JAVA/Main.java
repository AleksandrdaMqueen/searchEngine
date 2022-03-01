import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.resource.transaction.spi.TransactionStatus;


import java.util.List;


public class Main {

    public static void main(String[] args) {
        try {



            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata data = new MetadataSources(registry).getMetadataBuilder().build();

            SessionFactory sessionFactory = data.getSessionFactoryBuilder().build();

            Session session = sessionFactory.openSession();



            List<PurchaseList> purchaseLists = session.createQuery("FROM " + PurchaseList.class.getSimpleName()).getResultList();



            Transaction transaction = session.beginTransaction();

            purchaseLists.forEach(System.out::println);


            purchaseLists.forEach(purchaseList -> {
                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
                String courseName = purchaseList.getCourseName();
                String studentName = purchaseList.getStudentName();
                String hql = "From " + Student.class.getSimpleName() + " As s where s.name = " + "'" + studentName +"'";
                String hql2 = "From " + Course.class.getSimpleName() + " As c where c.name = " + "'" + courseName +"'";
                Student student = (Student) session.createQuery(hql).getSingleResult();
                Course course = (Course) session.createQuery(hql2).getSingleResult();
                int studentId = student.getId();
                int courseId = course.getId();
                LinkedKey linkedKey = new LinkedKey();
                linkedKey.setCourseId(courseId);
                linkedKey.setStudentId(studentId);
                linkedPurchaseList.setId(linkedKey);

               session.clear();


                session.saveOrUpdate(linkedPurchaseList);


            });
            transaction.commit();


            sessionFactory.close();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

