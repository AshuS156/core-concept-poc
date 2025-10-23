package pathfinder.thread.poc.playwithcompletable;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.playwithmap.EmployeeMap;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RunAysncDemo{
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        File jsonFile = new File("employees.json");
        new RunAysncDemo().loadData(jsonFile);
        new RunAysncDemo().loadDataWithCustomThreadPool(jsonFile);

    }

    public Void loadData(File jsonFile) throws ExecutionException, InterruptedException{

        ObjectMapper objectMapper = new ObjectMapper();
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {

            try {
                System.out.println("Thread name : " + Thread.currentThread().getName());
                final List<EmployeeMap> empList = objectMapper.readValue(jsonFile,new TypeReference<List<EmployeeMap>>(){});
                System.out.println("Employee Count : " + empList.size());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        final Void unused = completableFuture.get();
        return unused;

    }

    public Void loadDataWithCustomThreadPool(File jsonFile) throws ExecutionException, InterruptedException{

        ObjectMapper objectMapper = new ObjectMapper();
        Executor executor = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {

            try {
                System.out.println("Thread name : " + Thread.currentThread().getName());
                final List<EmployeeMap> empList = objectMapper.readValue(jsonFile,new TypeReference<List<EmployeeMap>>(){});
                System.out.println("Employee Count : " + empList.size());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } , executor);
        return  completableFuture.get();

    }
}
