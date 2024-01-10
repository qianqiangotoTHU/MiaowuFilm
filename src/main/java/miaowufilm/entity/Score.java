package miaowufilm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value="score")
public class Score {
    String filmname;
    int score;
}
