package javadeveloper.module4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<MaxProjectCountClient> findMaxProjectsClient() throws IOException, SQLException {
        List<MaxProjectCountClient> maxProjectCountClientList = new ArrayList<>();
        String sql = String.join("\n",
                Files.readAllLines(Path.of("sql/find_max_projects_client.sql")));
        ResultSet resultSet = Database.getInstance().executeQuery(sql);

        while (resultSet.next()) {
            maxProjectCountClientList.add(new MaxProjectCountClient(
                    resultSet.getString("name"),
                    resultSet.getInt("projects_count")
            ));
        }

        return maxProjectCountClientList;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() throws IOException, SQLException {
        List<MaxSalaryWorker> maxSalaryWorkerList = new ArrayList<>();
        String sql = String.join("\n",
                Files.readAllLines(Path.of("sql/ind_max_salary_worker.sql")));
        ResultSet resultSet = Database.getInstance().executeQuery(sql);

        while (resultSet.next()) {
            maxSalaryWorkerList.add(new MaxSalaryWorker(
                    resultSet.getString("name"),
                    resultSet.getInt("salary")
            ));
        }

        return maxSalaryWorkerList;
    }

    public List<LongestProject> findLongestProject() throws IOException, SQLException {
        List<LongestProject> longestProjectList = new ArrayList<>();
        String sql = String.join("\n",
                Files.readAllLines(Path.of("sql/find_longest_project.sql")));
        ResultSet resultSet = Database.getInstance().executeQuery(sql);

        while (resultSet.next()) {
            longestProjectList.add(new LongestProject(
                    resultSet.getString("name"),
                    resultSet.getInt("month_count")
            ));
        }

        return longestProjectList;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() throws IOException, SQLException {
        List<YoungestEldestWorkers> youngestEldestWorkersList = new ArrayList<>();
        String sql = String.join("\n",
                Files.readAllLines(Path.of("sql/find_youngest_eldest_workers.sql")));
        ResultSet resultSet = Database.getInstance().executeQuery(sql);

        while (resultSet.next()) {
            youngestEldestWorkersList.add(new YoungestEldestWorkers(
                    resultSet.getString("type"),
                    resultSet.getString("name"),
                    resultSet.getString("birthday")
            ));
        }

        return youngestEldestWorkersList;
    }

    public List<ProjectPrices> printProjectPrices() throws IOException, SQLException {
        List<ProjectPrices> projectPricesList = new ArrayList<>();
        String sql = String.join("\n",
                Files.readAllLines(Path.of("sql/print_project_prices.sql")));
        ResultSet resultSet = Database.getInstance().executeQuery(sql);

        while (resultSet.next()) {
            projectPricesList.add(new ProjectPrices(
                    resultSet.getString("name"),
                    resultSet.getInt("price")
            ));
        }

        return projectPricesList;
    }
}