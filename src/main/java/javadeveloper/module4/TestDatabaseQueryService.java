package javadeveloper.module4;

import javadeveloper.module4.storage.DatabaseQueryService;

import java.io.IOException;
import java.sql.SQLException;

public class TestDatabaseQueryService {
    public static void main(String[] args) throws IOException, SQLException {
        System.out.println(new DatabaseQueryService().findMaxProjectsClient());
        System.out.println(new DatabaseQueryService().findMaxSalaryWorker());
        System.out.println(new DatabaseQueryService().findLongestProject());
        System.out.println(new DatabaseQueryService().findYoungestEldestWorker());
        System.out.println(new DatabaseQueryService().printProjectPrices());
    }
}
