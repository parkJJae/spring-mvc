package com.sparta.springmvc.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello/request") // 중복 줄여주기
public class RequestController {
    @GetMapping("/form/html")
    public String helloform(){
        return "hello-request-form";
    }

    // [Request sample]
    // GET http://localhost:8080/hello/request/star/Robbie/age/95
    @GetMapping("/star/{name}/age/{age}") // 필요한 부분 {} 중괄호 안에 넣기
    @ResponseBody
    public String helloRequestPath(@PathVariable String name, @PathVariable int age)
    {
        return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);
    }

    // [Request sample]
// GET http://localhost:8080/hello/request/form/param?name=Robbie&age=95
    @GetMapping("/form/param")
    @ResponseBody
    public String helloGetRequestParam(@RequestParam String name, @RequestParam int age) { // ? 뒤에 나오는 값
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }


    // [Request sample]
// POST http://localhost:8080/hello/request/form/param
// Header
//  Content type: application/x-www-form-urlencoded
// Body
//  name=Robbie&age=95
    @PostMapping("/form/param") // Post는 body부분
    @ResponseBody
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }


    // [Request sample]
// POST http://localhost:8080/hello/request/form/model
// Header
//  Content type: application/x-www-form-urlencoded
// Body
//  name=Robbie&age=95
    @PostMapping("/form/model")
    @ResponseBody
    public String helloRequestBodyForm(@ModelAttribute Star star) { // body 부분에 들어온 데이터를 객체로 매핑 가능
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);
    }


    // [Request sample]
    // GET http://localhost:8080/hello/request/form/param/model?name=Robbie&age=95
    @GetMapping("/form/param/model")
    @ResponseBody
    public String helloRequestParam(@ModelAttribute Star star) { // 객체로 한 번에 받으면 길이가 길어지면 더 수월함.
        // setter 혹은 오버로딩 된 생성자가 필요함.
        // ModelAttribute 생략가능
        // 파라미터가 Simple value type -> int, Date , Integer 면 RequestParam
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);
    }


    // [Request sample]
// POST http://localhost:8080/hello/request/form/json
// Header
//  Content type: application/json
// Body
//  {"name":"Robbie","age":"95"}
    @PostMapping("/form/json")
    @ResponseBody
    public String helloPostRequestJson(@RequestBody Star star) { // HTTP 바디 부분 제이슨 형식으로 들어오면 @RequestBody
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);
    }
}
