package pathfinder.thread.poc.playwithfeatureobject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.playwithsorting.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WhyNotFeatureObjectWithSubmit{
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        File jsonFile = new File("employees.json");
        new WhyNotFeatureObjectWithSubmit().loadDataWithLambda(jsonFile);


    }

    private List<Employee> loadDataWithLambda(File jsonFile) throws ExecutionException, InterruptedException{

        // load data from DB
        ExecutorService service = Executors.newFixedThreadPool(10);

        ObjectMapper mapper = new ObjectMapper();
        final Future<List<Employee>> futureSubmit = service.submit(() -> {

            try {
                System.out.println("Thread with Lambda : " + Thread.currentThread().getName());
                List<Employee> employees = mapper.readValue(jsonFile,new TypeReference<List<Employee>>(){
                });
                System.out.println("Employee count with Lambda : :" + employees.size());
                return employees;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return  futureSubmit.get();

    }



}
