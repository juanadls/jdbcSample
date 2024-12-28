import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DemoJDBCSample {
    public static void main(String[] args) throws Exception {

        //Load and register:
        Class.forName("org.postgresql.Driver");

        //Connect app to DB
        String url = "jdbc:postgresql://localhost:5432/demo";
        String userName  = "postgres";
        String password  = "0000";
        String sqlQuery = "insert into students values (3, 'Jon', 48)";
        Connection connection = DriverManager.getConnection(url, userName, password);
        //Create a statement to fetch data from Postgres Db
        // 1. create a reference to the statement for later execution
        Statement statement = connection.createStatement();

        //it has added a user info
        boolean status = statement.execute(sqlQuery);
        //close connection
        connection.close();




    }
}