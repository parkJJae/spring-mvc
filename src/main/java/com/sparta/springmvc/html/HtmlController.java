package com.sparta.springmvc.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    private static long visitCount=0;

    @GetMapping("/static-hello")
    public String hello()
    {
        return "hello.html"; // -> String타입 반환 -> 이름에 부합하는 페이지를 찾아 반환
        // 하지만 Static이 아닌 templates 폴더에서 찾음 -> thymleaf: 동적처리
    }
    // 직접접근하는 것이 정적 페이지에는 맞지 않을까?

    @GetMapping("/html/redirect")
    public String htmlStatic(){
        return "redirect:/hello.html";
    }
    // 한 번 돌아서 요청

    @GetMapping("/html/templates")
    public String htmlTemplates(){
        return "hello"; // 이름 문자열 반환 -> templates 폴더에서 찾음
    }

    @GetMapping("/html/dynamic")
    public String htmlDynamic(Model model){
        visitCount ++;
        model.addAttribute("visits", visitCount);
        return "hello-visit";
    }
}
