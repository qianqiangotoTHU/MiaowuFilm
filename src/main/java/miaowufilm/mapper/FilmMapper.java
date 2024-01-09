package miaowufilm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import miaowufilm.entity.Film;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface FilmMapper extends BaseMapper<Film> {
}
