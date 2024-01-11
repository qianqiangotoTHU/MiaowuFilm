package miaowufilm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import miaowufilm.common.MD5Util;
import miaowufilm.entity.Users;
import miaowufilm.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import static miaowufilm.common.MD5Util.md5;

@Service
public class UsersService extends ServiceImpl<UsersMapper, Users> {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private RedisTemplate redisTemplate;


    public Users login(String email, String password) {
        // 进入数据库查询
        Users users=usersMapper.selectById(email);
        if(users != null && users.getPassword().equals(md5(password))) {
            System.out.println(users); // 打印users对象
            return users;
        }else{
            return null;
        }
    }

    public String register(String email, String passw1,String mname) {
        Users users = usersMapper.selectById(email);
        Users tbusers = new Users();
        tbusers.setMname(mname);
        tbusers.setEmail(email);
        tbusers.setPassword(md5(passw1));
        if (users!=null){
            return "该邮箱已注册！正在跳转到登录页...";
        }else {
            usersMapper.insert(tbusers);
            return "注册成功";
        }
    }

    public void setMyjifen(String email){
        // 进入数据库查询
        Users users=usersMapper.selectById(email);
        System.out.println(email);
        if(users != null && users.getJifen()==0) {
            // 打印users对象
            users.setJifen(1);
            usersMapper.updateById(users);
        }
    }

}
