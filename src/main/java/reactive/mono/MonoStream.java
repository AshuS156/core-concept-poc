package reactive.mono;

import reactor.core.publisher.Mono;

public class MonoStream{

    public static Mono<String> generateMono(){
        return Mono.just("Hello, Mono!");
    }


    public static Mono<String> generateMonoFromSupplier(){
        return Mono.fromSupplier(() -> "Hello from Supplier!");
    }

    public static Mono<Long> generateMonoUsingDelay(){
        return Mono.delay(java.time.Duration.ofSeconds(2));
    }


    public static Mono<String> generateMonoUsingEmpty(){
        return Mono.empty();
    }

    public static Mono<String> generateMonoUsingError(){
        return Mono.error(new RuntimeException("This is a Mono error"));
    }

    public static Mono<String> generateMonoUsingZip(){
        Mono<String> mono1 = Mono.just("Hello");
        Mono<String> mono2 = Mono.just("World");
        return Mono.zip(mono1, mono2, (s1, s2) -> s1 + " " + s2);
    }

    public static Mono<String> generateMonoUsingFlatMap(){
        return Mono.just("Reactive")
                .flatMap(s -> Mono.just(s + " Programming"));
    }

    public static Mono<Integer> generateMonoUsingMap(){
        return Mono.just("123")
                .map(Integer::parseInt);
    }

    public static Mono<String> generateMonoUsingFilter(){
        return Mono.just("FilterMe")
                .filter(s -> s.length() > 5);
    }

    public static Mono<Long> generateMonoUsingCount(){
        return Mono.just("CountMe")
                .map(String::length)
                .map(Long::valueOf);
    }

    public static Mono<String> generateMonoUsingDefaultIfEmpty(){
        return Mono.<String>empty()
                .defaultIfEmpty("Default Value");
    }
}
