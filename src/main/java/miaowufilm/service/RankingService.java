package miaowufilm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import miaowufilm.entity.Film;
import miaowufilm.mapper.RankingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class RankingService extends ServiceImpl<RankingMapper, Film> {
    @Autowired
    private RankingMapper rankingMapper;

    public Map<String, Object> getFilmRankingsByPlayNumber(Integer pageNo, Integer pageSize,Integer sort) {
        QueryWrapper<Film> queryWrapper = new QueryWrapper<>();
        // 根据播放量分数降序排序
       if(sort==1){queryWrapper.orderByDesc("play_number");}
        if(sort==3) {
          queryWrapper.orderByDesc("film_id");
        }
        if(sort==4){
            queryWrapper.orderByDesc("type");
        }
       else if(sort==2){ queryWrapper.orderByDesc("score");}
        // 计算满足查询条件的记录总数
        int count = rankingMapper.selectCount(queryWrapper).intValue();

        Page<Film> page = new Page<>(pageNo,pageSize);
        // 获取分页后的电影列表
        List<Film> filmList = rankingMapper.selectPage(page, queryWrapper).getRecords();

        // 创建返回的Map对象
        Map<String, Object> map = new HashMap<>();
        map.put("count", count);
        map.put("filmList", filmList);

        return map;
    }
}



