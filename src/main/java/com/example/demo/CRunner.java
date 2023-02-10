package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CRunner implements CommandLineRunner {

    private final TestClient testClient;

    @Value(value = "${url}")
    private String url;

    @Override
    public void run(String... args) {
        System.out.println("Staring with " + url);
        long t0 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            long t = System.currentTimeMillis();
            testClient.getPosts();
            System.out.println("req time: " + (System.currentTimeMillis() - t));
        }
        System.out.println("Total time of all requests: " + (System.currentTimeMillis() - t0));
    }
}
