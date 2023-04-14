package homework5.databaseService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        try {
            String sql = String.join("\n", Files.readAllLines(Paths.get("./sql/init_db.sql")));
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
