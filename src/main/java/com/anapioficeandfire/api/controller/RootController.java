package com.anapioficeandfire.api.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface RootController {
    ResponseEntity<Map<String, String>> endpointsData(HttpServletRequest request);
}
