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
        String password  = "";
        //String insertQuery = "insert into students values (3, 'Jon' , 48)";
        String updateQuery = "update students set sname = 'Juliet' where sid = 1";
        Connection connection = DriverManager.getConnection(url, userName, password);
        //Create a statement to fetch data from Postgres Db
        // 1. create a reference to the statement for later execution
        Statement statement = connection.createStatement();
        //it has added a user info
       // boolean insertStatus = statement.execute(insertQuery);
        boolean updateStatus = statement.execute(updateQuery);
        //close connection
        connection.close();




    }
}