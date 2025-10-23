package pathfinder.thread.poc.playwithcompletable;

import org.example.playwithmap.EmployeeMap;
import org.example.playwithmap.EmployeeMapUtils;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class ThenComposeDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        final List<EmployeeMap> employeeMaps = EmployeeMapUtils.loadEmployee();

       // thenCompose will use to combine only two dependent tasks.
        //1. create completable Future to collect all emp who training is incomplete
        //2, create completable future to send email to all emp collected in step 1

        ThenComposeDemo demo = new ThenComposeDemo();
       /* final CompletionStage<CompletableFuture<List<String>>> completableFutureCompletableFuture = demo.getAllEmployeeWithPendingTrainings(employeeMaps)
                .thenApply(employeeMaps1 -> demo.getEmails(employeeMaps));*/


        final CompletionStage<List<String>> listCompletableFuture = demo.getAllEmployeeWithPendingTrainings(employeeMaps).thenCompose(employees -> demo.getEmails(employees));
        System.out.println(listCompletableFuture.toCompletableFuture().get());


    }


    private CompletableFuture<List<EmployeeMap>> getAllEmployeeWithPendingTrainings(List<EmployeeMap> employeeMaps) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching employees who has incomplete trainings...");
            System.out.println("Thread name : " + Thread.currentThread().getName());
            return employeeMaps.stream()
                    .filter(employeeMap -> "TRUE".equalsIgnoreCase(employeeMap.getLearningPending()))
                    .collect(Collectors.toList());
        });
    }

    private CompletableFuture<List<String>> getEmails(List<EmployeeMap> employeeMaps) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Get email to all employees...");
            System.out.println("Thread name : " + Thread.currentThread().getName());
            return employeeMaps.stream().map(EmployeeMap::getEmail).collect(Collectors.toList());
        });
    }

}