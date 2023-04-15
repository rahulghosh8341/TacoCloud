package com.prac.spring.Controller;

import org.springframework.context.annotation.Configuration;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Controller
// public class HomeController {

//     @GetMapping("/")
//     public String Home() {
//         return "home";
//     }
// }

@Configuration
public class HomeController implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }
}