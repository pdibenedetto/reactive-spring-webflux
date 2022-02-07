package com.learnreactiveprogramming.service;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
public class FluxAndMonoGeneratorService {

    public static void main(String[] args) {
        FluxAndMonoGeneratorService svc = new FluxAndMonoGeneratorService();

        svc.namesFlux().subscribe(log::info);

        svc.nameMono()
                .subscribe(name -> log.info("Mono.just() " + name));
    }

    private final List<String> names =
            List.of(
                    "alex",
                    "mike",
                    "tiffany",
                    "shannon",
                    "jackie");

    // namesFlux is a publisher
    public Flux<String> namesFlux() {
        return Flux.fromIterable(names)
                .log();
    }

    // namesFlux is a publisher
    public Flux<String> namesFluxMap() {
        return Flux
                .fromIterable(names)
                .map(String::toUpperCase);
    }

    public Flux<String> namesFluxMap(int stringLength) {
        return Flux
                .fromIterable(names)
                .map(String::toUpperCase)
                .filter(string -> string.length() > stringLength);
    }


    public Flux<String> namesFluxImmutable() {
        var namesFlux = Flux.fromIterable(names);
        namesFlux.map(String::toUpperCase);
        return namesFlux;

    }
    // namesMono is a publisher
    public Mono<String> nameMono() {
        return Mono.just("Sophia").log();
    }


}
