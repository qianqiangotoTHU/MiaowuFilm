package miaowufilm.Controller;

import miaowufilm.entity.Actor;
import miaowufilm.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActorDetailController {
    @Autowired
    private ActorService actorService;
    @GetMapping("/actorlist{id}")
    public String actorDetail(@PathVariable Integer id, Model model){
        Actor actor=actorService.findById(id);
        model.addAttribute("actor",actor);

        return "actor_details";
    }

    @GetMapping("/actorlist/{actorname}")
    public String GetActorByName(@PathVariable String actorname, Model model){
        Actor actor=actorService.findByName(actorname);
        model.addAttribute("actor",actor);
        System.out.println(actor);
        return "actor_details";
    }
}
