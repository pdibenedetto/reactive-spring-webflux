package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxAndMonoGeneratorServiceTest {
    FluxAndMonoGeneratorService svc;

    @BeforeEach
    void setUp() {
        svc = new FluxAndMonoGeneratorService();
    }

    @Test
    void namesFlux() {
        // given

        // when
        var namesFlux = svc.namesFlux();

        // then
        StepVerifier
                .create(namesFlux)
                .expectNext(
                        "alex",
                        "mike",
                        "tiffany",
                        "shannon",
                        "jackie")
                .verifyComplete();
    }

    @Test
    void namesFluxCount() {
        // given

        // when
        var namesFlux
                = svc.namesFlux();

        // then
        StepVerifier
                .create(namesFlux)
                .expectNextCount(5)
                .verifyComplete();

        // then
        StepVerifier
                .create(namesFlux)
                .expectNext("alex")
                .expectNextCount(4)
                .verifyComplete();
    }

    @Test
    void nameMono() {
        // given

        // when
        var nameMono
                = svc.nameMono();

        // then
        StepVerifier
                .create(nameMono)
                .expectNextCount(1)
                .verifyComplete();
    }
}
