package miaowufilm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "comment")
public class Comment {
    String mname;
    String filmname;
    String comment;
}
