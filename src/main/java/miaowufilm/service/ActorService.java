package miaowufilm.service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import miaowufilm.entity.Actor;
import miaowufilm.entity.Film;
import miaowufilm.entity.film_actor;
import miaowufilm.mapper.ActorMapper;
import miaowufilm.mapper.FilmActorMapper;
import miaowufilm.mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ActorService extends ServiceImpl<ActorMapper, Actor> {
    @Autowired
    private ActorMapper actorMapper;
    @Autowired
    private FilmMapper filmMapper;
    @Autowired
    private FilmActorMapper filmActorMapper;

    private RedisTemplate redisTemplate;
    public List<Actor> findAll(){
        return actorMapper.selectList(null);
    }
    public Actor findById(Integer id){
      return actorMapper.selectById(id);
    }

    public Actor findByName(String actorname) {
        QueryWrapper<Actor> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("actorname",actorname);
        return actorMapper.selectOne(queryWrapper);
    }

    public List<Film> getFilmList(String actorname) {
        QueryWrapper<film_actor> qeryWrapper = new QueryWrapper<>();
        qeryWrapper.eq("actorname",actorname);
        List<film_actor> film_actorList = filmActorMapper.selectList(qeryWrapper);
        List<Film> filmList = new ArrayList<>();
        for(film_actor obj:film_actorList){
            QueryWrapper<Film> filmQueryWrapper = new QueryWrapper<>();
            filmQueryWrapper.eq("filmname",obj.getFilmname());
            Film film = filmMapper.selectOne(filmQueryWrapper);
            filmList.add(film);
        }
        return filmList;
    }


    public List<Actor> Search(String name) {
        QueryWrapper<Actor> queryWrapper = new QueryWrapper<>();
        if(name!=null&&!"".equals(name))
            queryWrapper.like("actorname",name);
        return actorMapper.selectList(queryWrapper);
    }
}
