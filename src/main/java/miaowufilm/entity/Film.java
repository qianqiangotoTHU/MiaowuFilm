package miaowufilm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
@TableName(value="film")
public class Film {
    @TableId
    private int film_id;
    private String filmname;
    private String file_haibao;
    private String bianju;
    private String director;
    private String type;
    private Date release_time;
    private Time length;
    private String introduce;
    private String video;
    private int play_number;
    private Double score;
    private String region;
    private int vip;
//getter and setter
}
