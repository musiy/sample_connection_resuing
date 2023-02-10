package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "test", url = "${url}")
public interface TestClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    String getPosts();
}
