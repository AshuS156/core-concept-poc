package reactive.mono;

public class PlayWithMono{
    public static void main(String[] args){
        MonoStream.generateMono().log()
                .subscribe(message -> System.out.println("Received message: " + message));


    }
}
