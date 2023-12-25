package miaowufilm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value="actor")
public class Actor {
    @TableId

    private int actorid;
    private String actorname;
    private String actorname_english;
    private String sex;
    private String actor_pic;

    private String star;

    private String birthdate;

    private String place;

    private String introduce;
    //getter and setter


}

