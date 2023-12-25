package miaowufilm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import miaowufilm.entity.Actor;
import miaowufilm.entity.Film;
import miaowufilm.mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService extends ServiceImpl<FilmMapper, Film> {
    @Autowired
   private FilmMapper filmMapper;
    public List<Film> findAll(){
        return filmMapper.selectList(null);
    }
    public Film findById(Integer id){
        return filmMapper.selectById(id);
    }
}
