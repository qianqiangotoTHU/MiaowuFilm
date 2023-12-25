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
    private int filmId;
    private String filmname;
    private String file_haibao;
    private String director;
    private String type;
    private Date release_time;
    private Time length;
    private String introduce;
    private String vedeo;
    private int play_number;
    private Double score;
//getter and setter
}
