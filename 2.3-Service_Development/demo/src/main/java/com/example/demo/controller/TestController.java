package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test") //리소스
public class TestController {

  @GetMapping
  public String testController() {
    return "Hello World!";
  }

  @GetMapping("/testGetMapping")
  public String testControllerWithPath() {
    return "Hello World! testGetMapping ";
  }

  @GetMapping("/{id}")
  public String testControllerWithPathVariables(@PathVariable(required = false) int id) {
    return "Hello World! ID " + id;
  }

  // /test경로는 이미 존재하므로 /test/testRequestParam으로 지정했다.
  @GetMapping("/testRequestParam")
  public String testControllerRequestParam(@RequestParam(required = false) int id) {
    return "Hello World! ID " + id;
  }

  // /test경로는 이미 존재하므로 /test/testRequestBody로 지정했다.
  @GetMapping("/testRequestBody")
  public ResponseDTO<String>  testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
    List<String> list = new ArrayList<>();
    list.add("Hello World! I'm ResponseDTO");
    ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
    return response;
  }

  @GetMapping("/testResponseEntity")
  public ResponseEntity<?> testControllerResponseEntity() {
    List<String> list = new ArrayList<>();
    list.add("Hello World! I'm ResponseEntity. And you got 400!");
    ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
    // http status 200를 원한다면
    // ResponseEntity.badRequest().body(response); 사용
    // http status를 400로 설정.
    return ResponseEntity.badRequest().body(response);
  }

}
