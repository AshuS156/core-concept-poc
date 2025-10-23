package pathfinder.thread.poc.playwithcompletable;

import org.example.playwithmap.EmployeeMap;
import org.example.playwithmap.EmployeeMapUtils;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class ThenApplyDemo{
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        final List<EmployeeMap> employeeMaps = EmployeeMapUtils.loadEmployee();

        // here all below task are dependent on other future
        // get list of gender using thenApply
        // get list of emp where rating is less than 4
        // get email of all employee
        // sent email to all
        ThenApplyDemo.getMaleGendersList(employeeMaps);

    }

    private static Void getMaleGendersList(List<EmployeeMap> employeeMaps) throws ExecutionException, InterruptedException{
        final CompletableFuture<Void> male = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching Male Employee...");
            System.out.println("Thread name : " + Thread.currentThread().getName());
            return employeeMaps.stream().filter(employeeMap -> employeeMap.getGender().equalsIgnoreCase("Male")).collect(Collectors.toList());
        }).thenApply(ThenApplyDemo::getEmpWithRatingLessThan4).thenApply(ThenApplyDemo::getEmailOfAllEmp).thenAccept(ThenApplyDemo::sendEmailToAllEmp);
        return male.get();

    }

    private  static List<EmployeeMap> getEmpWithRatingLessThan4(List<EmployeeMap> employeeMaps) {
         CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching employees with rating less than 4...");
            System.out.println("Thread name : "+Thread.currentThread().getName());
            return employeeMaps.stream()
                    .filter(employeeMap -> employeeMap.getRating() < 4)
                    .collect(Collectors.toList());
        });
       return null;
    }

    private static List<String> getEmailOfAllEmp(List<EmployeeMap> employeeMaps) {
         CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching email of all employees...");
            System.out.println("Thread name : "+Thread.currentThread().getName());
            return employeeMaps.stream()
                    .map(EmployeeMap::getEmail)
                    .collect(Collectors.toList());
        });
        return null;
    }

    private static void sendEmailToAllEmp(List<String> emails) {
         CompletableFuture.runAsync(() -> {
            System.out.println("Sending email to all employees...");
            System.out.println("Thread name : "+Thread.currentThread().getName());
            emails.forEach(email -> System.out.println("Email sent to: " + email));
        });

    }

}
