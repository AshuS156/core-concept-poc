package reactive.flux;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.*;

public class FluxStream{


    public static Flux<Integer> generateNumbersUsingRange(){
        return Flux.range(1,10).delayElements(Duration.ofMillis(500));

    }

    public static Flux<String> generateStringsUsingJust(){
        return Flux.just("Alpha","Beta","Gamma","Delta","Epsilon").delayElements(Duration.ofMillis(700));
    }


    public static Flux<String> generateFluxStreamUsingFromStream(){

        return Flux.fromStream(Stream.of("Ashu","Bittoo","Vritika","Khatu Shyam ji","Mahakal"));
    }

    public static Flux<String> generateFluxStreamUsingConcat(){

        return Flux.concat(generateStringsUsingJust(),generateFluxStreamUsingFromStream());
    }

    public static Flux<String> generateFluxStreamUsingCombineLatest(){
        return Flux.combineLatest(generateStringsUsingJust(),generateFluxStreamUsingFromStream(),(str1,str2) -> str1 + " - " + str2);
    }
}
