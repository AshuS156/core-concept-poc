package reactive.flux;

import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.List;

public class PlayWithFlux{
    public static void main(String[] args) throws IOException{
        final Flux<Integer> integerFlux = FluxStream.generateNumbersUsingRange();
        //integerFlux.subscribe(num -> System.out.println("Send data: " + num));


        // Flux.concat()
        //System.out.println("------Flux.concat()---------");
        //FluxStream.generateFluxStreamUsingConcat().log().subscribe(str -> System.out.println("Send data: " + str));

        // Flux.combineLatest
        //System.out.println("------Flux.combineLatest()---------");
       // FluxStream.generateFluxStreamUsingCombineLatest().log().subscribe(str -> System.out.println("Send data: " + str));


      /*  final List<Integer> list = FluxStream.generateNumbersUsingRange().toStream().toList();

        System.out.println("List" + list);
        System.out.println("List size: " + list.size());*/

        final List<String> list1 = FluxStream.generateFluxStreamUsingConcat().toStream().toList();
        System.out.println("List1: " + list1);
        System.out.println("List1 size: " + list1.size());


        System.in.read();

    }
}
