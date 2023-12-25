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
@RequestMapping("/actorlist")
public class ActorDetailController {
    @Autowired
    private ActorService actorService;
    @GetMapping("/{id}")
    public String actorDetail(@PathVariable Integer id, Model model){
        Actor actor=actorService.findById(id);
        model.addAttribute("actor",actor);
        return "actor_details";
    }
}
