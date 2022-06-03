package com.anapioficeandfire.api.controller;

import java.net.InetAddress;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class RootControllerImpl implements RootController{

    @GetMapping("")
    @Override
    public ResponseEntity<Map<String, String>> endpointsData(HttpServletRequest request) {
        var baseUrl = request.getRequestURL().toString();
        return ResponseEntity.ok(Map.of("books", baseUrl + "books",
                "characters", baseUrl + "characters",
                "houses", baseUrl + "houses"));

    }
}
