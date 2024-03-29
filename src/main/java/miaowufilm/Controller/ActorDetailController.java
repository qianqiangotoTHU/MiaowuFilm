package miaowufilm.Controller;

import miaowufilm.entity.Actor;
import miaowufilm.entity.Film;
import miaowufilm.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ActorDetailController {
    @Autowired
    private ActorService actorService;
//    @GetMapping("/actorlist/{id}")
//    public String actorDetail(@PathVariable Integer id, Model model){
//        Actor actor=actorService.findById(id);
//        model.addAttribute("actor",actor);
//
//        return "actor_details";
//    }

    @GetMapping("/actordetail/{actorname}")
    public String GetActorByName(@PathVariable String actorname, Model model){
        Actor actor=actorService.findByName(actorname);
        model.addAttribute("actor",actor);
        List<Film> filmlist = actorService.getFilmList(actorname);
        model.addAttribute("filmList",filmlist);
        return "actor_details";
    }

}
