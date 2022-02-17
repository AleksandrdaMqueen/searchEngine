import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "polar12Bear";
        try {
            int lastNum = 0;
            int count = 0;


            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            Statement statement1 = connection.createStatement();
            Statement statement2 = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT subscription_date as date , course_name as name FROM purchaselist WHERE YEAR(subscription_date) = 2018 ORDER BY subscription_date");

            ResultSet getLastNum = statement1.executeQuery("SELECT MONTH(subscription_date) as date FROM purchaselist WHERE YEAR(subscription_date) = 2018 ORDER BY subscription_date ");

            while (resultSet.next()) {
                count++;
                resultSet.getString("name");
                resultSet.getString("date");
            }
            while (getLastNum.next()){
                lastNum = getLastNum.getInt("date");

            }

            int result = count/lastNum;


            statement.close();
            resultSet.close();
            connection.close();
            getLastNum.close();
            statement1.close();
            statement2.close();

            System.out.println(result);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
