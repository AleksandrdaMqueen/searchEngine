import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "polar12Bear";
        try {



            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT course_name as course_name,\n" +
                    "count(subscription_date) / (max(month(subscription_date)) - (min(month(subscription_date)))+1)  as avg_price \n" +
                    "from purchaselist  where year(subscription_date) = 2018 group by course_name");

            System.out.println("Средниие продажи по каждому курсу:");
            while (resultSet.next()){
                System.out.println(resultSet.getString("course_name") + " "+resultSet.getString("avg_price"));
            }



        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
