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
            int months = 0;
            int count = 0;
            ArrayList<String> arrayOfNames = new ArrayList<>();

            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            Statement statement1 = connection.createStatement();
            Statement statement2 = connection.createStatement();
            Statement statement3 = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT subscription_date as date , course_name as name FROM purchaselist WHERE YEAR(subscription_date) = 2018 ORDER BY subscription_date");

            ResultSet getLastNum = statement1.executeQuery("SELECT MONTH(subscription_date) as date FROM purchaselist WHERE YEAR(subscription_date) = 2018 ORDER BY subscription_date");
            ResultSet name = statement2.executeQuery("SELECT  name  as name FROM courses");
            while (name.next()) {
                arrayOfNames.add(name.getString("name"));
            }
            while (getLastNum.next()) {
                months = getLastNum.getInt("date");

            }


            for (int i = 0; i <= arrayOfNames.size() -1 ; i++) {
                String names = arrayOfNames.get(i);
                ResultSet resultSet1 = statement3.executeQuery("SELECT subscription_date as date from purchaselist WHERE name = " + names);
                while (resultSet1.next()){
                    count++;

                }
                int res = count/ months;
                System.out.println("Средние продажи в месяц курса " + names + "равна " + res);

            }


            statement.close();
            resultSet.close();
            connection.close();
            getLastNum.close();
            statement1.close();
            statement2.close();


        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
