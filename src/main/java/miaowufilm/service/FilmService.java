package miaowufilm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import miaowufilm.entity.Film;
import miaowufilm.entity.film_actor;
import miaowufilm.mapper.FilmActorMapper;
import miaowufilm.mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FilmService extends ServiceImpl<FilmMapper, Film> {
    @Autowired
    private FilmMapper filmMapper;
    @Autowired
    private FilmActorMapper filmActorMapper;
    public List<Film> findAll(){
        return filmMapper.selectList(null);
    }
    public Film findById(Integer id){
        return filmMapper.selectById(id);
    }

    public Map<String,Object> queryPage(Integer pageNo, Integer pageSize, String region, String type, Integer sort) {
        QueryWrapper<Film> queryWrapper=new QueryWrapper<>();
        if (!"".equals(region) && region!=null) queryWrapper.eq("region",region);
        if (!"".equals(type) && type!=null) queryWrapper.eq("type",type);
        if(sort==1) queryWrapper.orderByDesc("play_number");
        else if(sort==2) queryWrapper.orderByDesc("release_time");
        else if (sort==3) queryWrapper.orderByDesc("score");
        int count=filmMapper.selectCount(queryWrapper).intValue();
        //构建分页对象（第一个参数是当前页数，第二个参数是每页条数
        Page<Film> page=new Page<>(pageNo,pageSize);
        Page<Film> flowerPage=filmMapper.selectPage(page,queryWrapper);
        Map<String,Object> map=new HashMap<>();
        map.put("count",count);
        map.put("filmList",flowerPage.getRecords());
        return map;
    }

    public List<film_actor> findActors(String filmname){
        QueryWrapper<film_actor> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("filmname",filmname);
        return filmActorMapper.selectList(queryWrapper);
    }
}
