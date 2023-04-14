package homework5.databaseService;

import homework5.databaseContent.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private Database database;

    public DatabaseQueryService(Database database) {
        this.database = database;
    }

    public List<ProjectPrices> findProjectPrices() {
        List<ProjectPrices> prices = new ArrayList<>();
        try (Statement st = database.getConnection().createStatement()) {
            String sql = String.join("\n", Files.readAllLines(Path.of("./sql/print_project_prices.sql")));
            try (ResultSet rs = st.executeQuery(sql)) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    prices.add(new ProjectPrices(name, price));
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return prices;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorker() {
        List<YoungestEldestWorker> workers = new ArrayList<>();
        try (Statement st = database.getConnection().createStatement()) {
            String sql = String.join("\n", Files.readAllLines(Path.of("./sql/find_youngest_eldest_workers.sql")));
            try (ResultSet rs = st.executeQuery(sql)) {
                while (rs.next()) {
                    String type = rs.getString("type");
                    String name = rs.getString("name");
                    Date birthday = rs.getDate("birthday");
                    workers.add(new YoungestEldestWorker(type, name, birthday));
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return workers;
    }

    public List<MaxProjectCountClient> findMaxProjectCountClient() {
        List<MaxProjectCountClient> clients = new ArrayList<>();
        try (Statement st = database.getConnection().createStatement()) {
            String sql = String.join("\n", Files.readAllLines(Path.of("./sql/find_max_projects_client.sql")));
            try (ResultSet rs = st.executeQuery(sql)) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    int cnt = rs.getInt("cnt");
                    clients.add(new MaxProjectCountClient(name, cnt));
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> msw = new ArrayList<>();
        try (Statement st = database.getConnection().createStatement()) {
            String sql = String.join("\n", Files.readAllLines(Path.of("./sql/find_max_salary_worker.sql")));
            try (ResultSet rs = st.executeQuery(sql)) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    int salary = rs.getInt("salary");
                    msw.add(new MaxSalaryWorker(name, salary));
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return msw;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> lp = new ArrayList<>();
        try (Statement st = database.getConnection().createStatement()) {
            String sql = String.join("\n", Files.readAllLines(Path.of("./sql/find_longest_project.sql")));
            try (ResultSet rs = st.executeQuery(sql)) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    int month_count = rs.getInt("month_count");
                    lp.add(new LongestProject(name, month_count));
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return lp;
    }
}
