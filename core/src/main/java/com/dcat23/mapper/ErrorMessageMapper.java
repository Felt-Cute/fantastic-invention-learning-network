package com.dcat23.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ErrorMessageMapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String mapToJson(String message, String path, HttpStatus statusCode) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("path", path);
        map.put("message", message);
        map.put("statusCode", statusCode);
        map.put("timestamp", LocalDateTime.now().toString());
        return mapper.writeValueAsString(map);
    }
}
