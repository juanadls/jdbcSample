import org.postgresql.ds.PGSimpleDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        Properties props = new Properties();
        try {
            props.load(Files.newInputStream(Path.of("demo.properties"),
                    StandardOpenOption.READ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        var databaseSource = new PGSimpleDataSource();
        databaseSource.setServerNames(new String[]{props.getProperty("serverName")});
        databaseSource.setPortNumbers(new int[]{Integer.parseInt(props.getProperty("port"))});
        databaseSource.setDatabaseName(props.getProperty("databaseName"));

        try (var connection = databaseSource.getConnection(props.getProperty("user"), System.getenv("POSTGRESQL_PASS"))
        ) {
            System.out.println("Success");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}