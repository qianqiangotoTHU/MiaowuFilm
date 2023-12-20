package miaowufilm.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value="user")
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private String email;
    private String password;
    private String mname;
    private int jifen;
}
