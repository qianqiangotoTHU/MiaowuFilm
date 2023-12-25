package miaowufilm.Controller;

import miaowufilm.entity.Actor;
import miaowufilm.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/actorlist")
public class ActorIndexController {
    @Autowired
    private ActorService actorService;
   @RequestMapping("/")
    public String actorlist(Model model){
        List<Actor>actorList=actorService.findAll();
       model.addAttribute("actors",actorList);
        return "actorlist";
    }
}
