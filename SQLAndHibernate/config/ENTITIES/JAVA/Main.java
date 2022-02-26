import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        try {




            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata data = new MetadataSources(registry).getMetadataBuilder().build();

            SessionFactory sessionFactory = data.getSessionFactoryBuilder().build();

            Session session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<PurchaseList> query = builder.createQuery(PurchaseList.class);


            Root<PurchaseList> root = query.from(PurchaseList.class);
            List<PurchaseList> purchaseLists = session.createQuery(query).getResultList();

            query.select(root);

            Transaction transaction = session.beginTransaction();
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();

            purchaseLists.forEach(purchaseList -> {
                String courseName = purchaseList.getCourseName();
                String studentName = purchaseList.getStudentName();
                String hql = "From" + Student.class.getSimpleName() + " As s where s.name = " + "'" + studentName +"'";
                String hql2 = "From" + Course.class.getSimpleName() + " As c where c.name = " + "'" + courseName +"'";
                Student student = (Student) session.createQuery(hql).getSingleResult();
                Course course = (Course) session.createQuery(hql2).getSingleResult();
                int studentId = student.getId();
                int courseId = course.getId();
                linkedPurchaseList.setStudentId(studentId);
                linkedPurchaseList.setCourseId(courseId);
            });


            session.save(linkedPurchaseList);
            transaction.commit();
            sessionFactory.close();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }



    }

}


