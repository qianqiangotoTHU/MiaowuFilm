package miaowufilm.Controller;

import miaowufilm.entity.Users;
import miaowufilm.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.servlet.http.HttpSession;


@Controller
public class UsersController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @Autowired
    private UsersService usersService;


    @RequestMapping("/index/toLogin")
    public  String toLogin(){
        return "login";
    }

    @RequestMapping("/index/doLogin")
    @ResponseBody
    public String doLogin(String email, String password, HttpSession session) {
        Users users = usersService.login(email, password);
        if (users != null) {
            users.setPassword(""); //去敏
            session.setAttribute("usersLogin", users);
            return "succeed";
        } else {
            return "登录失败!";
        }
    }

    @RequestMapping("/index/logOut")
    public String logOut( HttpSession session){
        session.removeAttribute("usersLogin");
        return "redirect:/index";
    }

    @RequestMapping("/index/toRegister")
    public String toRegister(){
        return "register";
    }


    @RequestMapping("/index/doRegister")
    @ResponseBody
    public String doRegister(String email,String passw1){
        String flag =  usersService.register(email,passw1);
        return flag;
    }

    @RequestMapping("/index/toVipCharge")
    public String toVipCharge(){
        return "VipCharge";
    }

    @RequestMapping("/index/doVipCharge")
    @ResponseBody
    public String checkLoginStatus(HttpSession session) {
        Users users = (Users) session.getAttribute("usersLogin");
        if (users == null) {
            return "未登录";
        } else if(users!=null && users.getJifen()==0) {
            usersService.setMyjifen(users.getEmail());
            users.setJifen(1);
            session.setAttribute("usersLogin",users);
            return "novip";
        }
            else return "您已是vip,请勿重复充值！";
    }

}
