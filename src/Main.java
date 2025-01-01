import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
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

    }
}