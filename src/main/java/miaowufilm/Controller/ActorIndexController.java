package miaowufilm.Controller;

import miaowufilm.entity.Actor;
import miaowufilm.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ActorIndexController {
    @Autowired
    private ActorService actorService;
    @RequestMapping("/actorlist")
    public String actorlist(String search,
                            Model model){
       List<Actor>actorList=actorService.Search(search);
       model.addAttribute("actors",actorList);

       return "actorlist";
    }

}
