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

    // namesFlux is a publisher
    public Flux<String> namesFlux() {
        return Flux.fromIterable(List.of(
                "alex",
                "mike",
                "tiffany",
                "shannon",
                "jackie"))
                .log();
    }

    // namesMono is a publisher
    public Mono<String> nameMono() {
        return Mono.just("Sophia").log();
    }


}
