package pathfinder.thread.poc.playwithcompletable;

import org.example.playwithmap.EmployeeMap;
import org.example.playwithmap.EmployeeMapUtils;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class ThenApplyAsyncDemo{
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        final List<EmployeeMap> employeeMaps = EmployeeMapUtils.loadEmployee();

        // here all below task are dependent on other future
        // get list of gender using thenApply
        // get list of emp where rating is less than 4
        // get email of all employee
        // sent email to all

        final CompletableFuture<Void> male = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching Male Employee...");
            System.out.println("Thread name : " + Thread.currentThread().getName());
            return employeeMaps.stream().filter(employeeMap -> employeeMap.getGender().equalsIgnoreCase("Male")).collect(Collectors.toList());
        }).thenApplyAsync(employeeMaps1 -> {
            System.out.println("Fetching employees with rating less than 4...");
            System.out.println("Thread name : " + Thread.currentThread().getName());
            return employeeMaps1.stream()
                    .filter(employeeMap -> employeeMap.getRating() < 4)
                    .collect(Collectors.toList());
        }).thenApplyAsync(employeeMaps12 -> {
            System.out.println("Fetching email of all employees...");
            System.out.println("Thread name : " + Thread.currentThread().getName());
            return employeeMaps12.stream()
                    .map(EmployeeMap::getEmail)
                    .collect(Collectors.toList());
        }).thenAcceptAsync(emails -> {
            System.out.println("Sending email to all employees...");
            System.out.println("Thread name : " + Thread.currentThread().getName());
            emails.forEach(email -> System.out.println("Email sent to: " + email));
        });

       System.out.println("Void male : "+ male.get());
    }

}
