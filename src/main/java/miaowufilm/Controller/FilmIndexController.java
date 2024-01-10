package miaowufilm.Controller;

import miaowufilm.entity.Film;
import miaowufilm.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class FilmIndexController {
    @Autowired
    private FilmService filmService;

    private Integer pageSize=5;

    @RequestMapping("/index")
    public String filmlist(@RequestParam(name = "pageNo",defaultValue = "1")Integer pageNo,
                           @RequestParam(name = "region",defaultValue = "")String region,
                           @RequestParam(name = "type",defaultValue = "")String type,
                           @RequestParam(name = "sort",defaultValue = "1")Integer sort,
                           Model model){
        Map<String,Object> map = filmService.queryPage(pageNo,pageSize,region,type,sort);
        Integer count = (Integer)map.get("count");
        int pageCount = (count%pageSize==0)?(count/pageSize):(count/pageSize+1);
        List<Film> filmList = (List<Film>) map.get("filmList");
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("films",filmList);
        model.addAttribute("region",region);
        model.addAttribute("type",type);
        model.addAttribute("sort",sort);
        return "index";
    }
}
