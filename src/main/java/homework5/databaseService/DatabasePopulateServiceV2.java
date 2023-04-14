package homework5.databaseService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateServiceV2 {
    private PreparedStatement worker;
    private PreparedStatement client;
    private PreparedStatement project;
    private PreparedStatement project_worker;

    public DatabasePopulateServiceV2(Database database) {
        Connection conn = database.getConnection();
        try {
            worker = conn.prepareStatement("insert into worker (name, birthday, level, salary) values (?, ?, ?, ?)");
            client = conn.prepareStatement("insert into client(name) values (?)");
            project = conn.prepareStatement("insert into project(client_id, start_date, finish_date) values (?, ?, ?)");
            project_worker = conn.prepareStatement("insert into project_worker(project_id, worker_id) values (?, ?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insertWorker(String name, String birthday, String level, int salary) {
        try {
            worker.setString(1, name);
            worker.setString(2, birthday);
            worker.setString(3, level);
            worker.setInt(4, salary);
            return worker.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertWorker() {
        try {
            String[] sql = String.join("", Files.readAllLines(Path.of("./sql/populate_worker.sql"))).split(";");
            for (String s : sql) {
                String[] split = s.replaceAll(" ", "").replaceAll("'","").split(",");
                worker.setString(1, split[0]);
                worker.setString(2, split[1]);
                worker.setString(3, split[2]);
                worker.setInt(4, Integer.parseInt(split[3]));
                worker.addBatch();
            }
            worker.executeBatch();
            return true;
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertClient(String name) {
        try {
            client.setString(1, name);
            return client.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertClient() {
        try {
            String[] sql = String.join("", Files.readAllLines(Path.of("./sql/populate_client.sql")))
                    .replaceAll("'", "")
                    .split(";");
            for (String s : sql) {
                client.setString(1, s);
                client.addBatch();
            }
            client.executeBatch();
            return true;
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertProject(int clientId, String startDate, String finishDate) {
        try {
            project.setInt(1, clientId);
            project.setString(2, startDate);
            project.setString(3, finishDate);
            return project.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertProject() {
        try {
            String[] sql = String.join("", Files.readAllLines(Path.of("./sql/populate_project.sql"))).split(";");
            for (String s : sql) {
                String[] split = s.replaceAll(" ", "").replaceAll("'","").split(",");
                project.setString(1, split[0]);
                project.setString(2, split[1]);
                project.setString(3, split[2]);
                project.addBatch();
            }
            project.executeBatch();
            return true;
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertProjectWorker(int projectId, int workerId) {
        try {
            project_worker.setInt(1, projectId);
            project_worker.setInt(2, workerId);
            return project_worker.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertProjectWorker() {
        try {
            String[] sql = String.join("", Files.readAllLines(Path.of("./sql/populate_project_worker.sql"))).split(";");
            for (String s : sql) {
                String[] split = s.replaceAll(" ", "").split(",");
                project_worker.setLong(1, Integer.parseInt(split[0]));
                project_worker.setLong(2, Integer.parseInt(split[1]));
                project_worker.addBatch();
            }
            project_worker.executeBatch();
            return true;
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
