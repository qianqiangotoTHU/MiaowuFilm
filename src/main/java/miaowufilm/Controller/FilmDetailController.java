package miaowufilm.Controller;

import miaowufilm.entity.Actor;
import miaowufilm.entity.Film;
import miaowufilm.entity.Users;
import miaowufilm.entity.film_actor;
import miaowufilm.service.ActorService;
import miaowufilm.service.FilmService;
import miaowufilm.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FilmDetailController {
    @Autowired
    private FilmService filmService;
    private UsersService usersService;

    @GetMapping("/index/{Id}")
    public String filmdetail(@PathVariable Integer Id, Model model){
        Film film=filmService.findById(Id);
        model.addAttribute("film",film);
        String filmname = film.getFilmname();
        List<film_actor> film_actors = filmService.findActors(filmname);
        model.addAttribute("actors",film_actors);
        model.addAttribute("id",Id);
        return "movie_details";
    }

    @RequestMapping("/index/VipFilm")
    @ResponseBody
    public String CheckVipPlay(HttpSession session,Integer vip){
        Users users = (Users) session.getAttribute("usersLogin");
        if (users == null) {
            return "未登录";
        }
        else if(users!=null && vip==1 && users.getJifen()==0){//电影需要vip,用户不是vip
            return "needVip";
        }
        else return "playFilm";
    }

}
