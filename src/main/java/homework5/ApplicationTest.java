package homework5;

import homework5.databaseService.Database;
import homework5.databaseService.DatabasePopulateServiceV2;
import homework5.databaseService.DatabaseQueryService;

import java.util.List;

public class ApplicationTest {
    public static void main(String[] args) {

        DatabasePopulateServiceV2 populateService = new DatabasePopulateServiceV2(Database.getInstance());

        populateService.insertWorker();
        populateService.insertClient();
        populateService.insertProject();
        populateService.insertProjectWorker();

        
//        DatabaseQueryService db = new DatabaseQueryService(Database.getInstance());
//
//        printList(db.findMaxSalaryWorker());
//        printList(db.findLongestProject());
//        printList(db.findMaxProjectCountClient());
//        printList(db.findYoungestEldestWorker());
//        printList(db.findProjectPrices());

    }

    private static void printList(List list) {
        list.forEach(System.out::println);
    }
}
