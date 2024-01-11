package miaowufilm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import miaowufilm.entity.Film;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RankingMapper extends BaseMapper<Film> {
}
