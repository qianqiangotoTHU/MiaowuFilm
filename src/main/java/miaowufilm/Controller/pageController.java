package miaowufilm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pageController {
//    @RequestMapping("/index/")
//    public String index() {
//        return "index";
//    }

    @RequestMapping("/ranking/")
    public String ranking() {
        return "ranking";
    }

//    @RequestMapping("/actorlist/")
//    public String actorlist() {
//        return "actorlist";
//    }

//    @RequestMapping("/actordetails/")
//    public String actordetails() {
//        return "actor_details";
//    }

    @RequestMapping("/moviedetails/")
    public String moviedetails() {
        return "movie_details";
    }
}
