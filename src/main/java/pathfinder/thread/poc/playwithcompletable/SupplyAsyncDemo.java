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

public class SupplyAsyncDemo{
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        SupplyAsyncDemo demo = new SupplyAsyncDemo();
        demo.loadDataWithCustomThreadPool(new File("employees.json"));


    }

    public List<EmployeeMap> loadDataWithCustomThreadPool(File jsonFile) throws ExecutionException, InterruptedException{

        ObjectMapper objectMapper = new ObjectMapper();
        Executor executor = Executors.newFixedThreadPool(5);

        final CompletableFuture<List<EmployeeMap>> listCompletableFuture = CompletableFuture.supplyAsync(() -> {
            List<EmployeeMap> empList = null;
            try {
                System.out.println("Thread name : " + Thread.currentThread().getName());
                empList = objectMapper.readValue(jsonFile,new TypeReference<List<EmployeeMap>>(){
                });
                System.out.println("Employee Count : " + empList.size());
                return empList;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        },executor);

        return listCompletableFuture.get();
    }
}
