package miaowufilm.Controller;

import miaowufilm.entity.Film;
import miaowufilm.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/index")
public class FilmIndexController {
    @Autowired
    private FilmService filmService;
  @RequestMapping("/")
    public String filmlist(Model model){
        List<Film> filmList=filmService.findAll();
        model.addAttribute("films",filmList);
        return "index";
    }
}
