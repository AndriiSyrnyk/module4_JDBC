package javadeveloper.module4.storage;

import javadeveloper.module4.queryResultClasses.*;

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
        ResultSet resultSet = Database.getInstance()
                .executeQuery(readSqlFromFile("sql/find_max_projects_client.sql"));

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
        ResultSet resultSet = Database.getInstance()
                .executeQuery(readSqlFromFile("sql/ind_max_salary_worker.sql"));

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
        ResultSet resultSet = Database.getInstance()
                .executeQuery(readSqlFromFile("sql/find_longest_project.sql"));

        while (resultSet.next()) {
            longestProjectList.add(new LongestProject(
                    resultSet.getString("name"),
                    resultSet.getInt("month_count")
            ));
        }

        return longestProjectList;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorker() throws IOException, SQLException {
        List<YoungestEldestWorker> youngestEldestWorkerList = new ArrayList<>();
        ResultSet resultSet = Database.getInstance()
                .executeQuery(readSqlFromFile("sql/find_youngest_eldest_workers.sql"));

        while (resultSet.next()) {
            youngestEldestWorkerList.add(new YoungestEldestWorker(
                    resultSet.getString("type"),
                    resultSet.getString("name"),
                    resultSet.getString("birthday")
            ));
        }

        return youngestEldestWorkerList;
    }

    public List<ProjectPrices> printProjectPrices() throws IOException, SQLException {
        List<ProjectPrices> projectPricesList = new ArrayList<>();
        ResultSet resultSet = Database.getInstance()
                .executeQuery(readSqlFromFile("sql/print_project_prices.sql"));

        while (resultSet.next()) {
            projectPricesList.add(new ProjectPrices(
                    resultSet.getString("name"),
                    resultSet.getInt("price")
            ));
        }

        return projectPricesList;
    }

    private String readSqlFromFile(String path) throws IOException {
        return String.join("\n",
                Files.readAllLines(Path.of(path)));
    }
}