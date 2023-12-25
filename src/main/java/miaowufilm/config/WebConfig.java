package miaowufilm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.net.http.WebSocket;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/actorlist").setViewName("forward:/actorlist/index");
        registry.addViewController("actorlist/{id}").setViewName("forward:/actorlist/actordetails");
        registry.addViewController("/index/").setViewName("forward:/index/");
        registry.addViewController("/index/{Id}").setViewName("forward:/index/filmdetail");
    }
}
