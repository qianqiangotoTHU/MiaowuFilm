package miaowufilm.service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import miaowufilm.entity.Actor;
import miaowufilm.mapper.ActorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ActorService extends ServiceImpl<ActorMapper, Actor> {
    @Autowired
    private ActorMapper actorMapper;
    private RedisTemplate redisTemplate;
    public List<Actor> findAll(){
        return actorMapper.selectList(null);
    }
    public Actor findById(Integer id){
      return actorMapper.selectById(id);
    }
}
