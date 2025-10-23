package pathfinder.thread.poc.playwithfeatureobject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.playwithsorting.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WhyNotFeatureObject{
    public static void main(String[] args){
        File jsonFile = new File("employees.json");
        new WhyNotFeatureObject().loadData(jsonFile);
        new WhyNotFeatureObject().loadDataWithLambda(jsonFile);


    }

    private Void loadData(File jsonFile){

        // load data from DB
        ExecutorService service = Executors.newFixedThreadPool(10);

        ObjectMapper mapper = new ObjectMapper();
      service.execute(new Runnable(){
            @Override
            public void run(){

                try {
                    System.out.println("Thread : " + Thread.currentThread().getName());
                    List<Employee> employees = mapper.readValue(jsonFile,new TypeReference<List<Employee>>(){});
                    System.out.println("Employee count :" + employees.size());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        return null;
    }

    private Void loadDataWithLambda(File jsonFile){

        // load data from DB
        ExecutorService service = Executors.newFixedThreadPool(10);

        ObjectMapper mapper = new ObjectMapper();
        service.execute(() -> {

                try {
                    System.out.println("Thread with Lambda : " + Thread.currentThread().getName());
                    List<Employee> employees = mapper.readValue(jsonFile,new TypeReference<List<Employee>>(){});
                    System.out.println("Employee count with Lambda : :" + employees.size());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        });
        return null;
    }



}
