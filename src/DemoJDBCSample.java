import java.sql.Connection;
import java.sql.DriverManager;

public class DemoJDBCSample {
    public static void main(String[] args) throws Exception {

        //Load and register:
        Class.forName("org.postgresql.Driver");
        //Connect app to DB

        String url = "jdbc:postgresql://localhost:5432/demo";
        String userName  = "postgres";
        String password  = "0000";
        Connection connection = DriverManager.getConnection(url, userName, password);
    }
}