package miaowufilm.Controller;

import miaowufilm.entity.Actor;
import miaowufilm.entity.Film;
import miaowufilm.entity.film_actor;
import miaowufilm.service.ActorService;
import miaowufilm.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FilmDetailController {
    @Autowired
    private FilmService filmService;
    @GetMapping("/index/{Id}")
    public String filmdetail(@PathVariable Integer Id, Model model){
        Film film=filmService.findById(Id);
        model.addAttribute("film",film);
        String filmname = film.getFilmname();
        List<film_actor> film_actors = filmService.findActors(filmname);
        model.addAttribute("actors",film_actors);
        return "movie_details";
    }
}
