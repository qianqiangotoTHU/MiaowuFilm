package miaowufilm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value="film_actor")
public class film_actor {
    int id;
    String filmname;
    String actorname;
}
