package miaowufilm.Controller;

import miaowufilm.entity.Film;
import miaowufilm.service.ActorService;
import miaowufilm.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class FilmDetailController {
    @Autowired
    private FilmService filmService;
    @GetMapping("/{Id}")
    public String filmdetail(@PathVariable Integer Id, Model model){
        Film film=filmService.findById(Id);
        model.addAttribute("film",film);
        return "movie_details";
    }
}
