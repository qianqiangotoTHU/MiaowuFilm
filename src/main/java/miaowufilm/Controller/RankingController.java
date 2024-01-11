package miaowufilm.Controller;

import miaowufilm.entity.Film;
import miaowufilm.service.FilmService;
import miaowufilm.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class RankingController {
    @Autowired
    private RankingService rankingService;

    private Integer pageSize=5;

    @RequestMapping("/ranking")
    public String ranklist(@RequestParam(name = "pageNo",defaultValue = "1")Integer pageNo,
                           @RequestParam(name = "sort",defaultValue = "1")Integer sort,
                           Model model){
        Map<String,Object> map = rankingService.getFilmRankingsByPlayNumber(sort);



        List<Film> filmList = (List<Film>) map.get("filmList");

        model.addAttribute("currentPage",pageNo);
        model.addAttribute("films",filmList);
        model.addAttribute("sort",sort);
        return "ranking";
    }
}
