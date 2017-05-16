package online.edu.controller;



import com.alibaba.fastjson.JSONObject;
import online.edu.entity.CourseType;
import online.edu.entity.User;
import online.edu.util.Md5Util;
import online.edu.servive.CourseTypeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/user")
public class LoginController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(LoginController.class);

    @Autowired
    CourseTypeService courseTypeService;

    /**
     * 登录
     * @param response
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(HttpServletResponse response, User user, HttpServletRequest request, HttpSession session){
        ServletContext application= RequestContextUtils.getWebApplicationContext(request).getServletContext();
        log.info("-exe-");
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), Md5Util.md5(user.getPassword()));
        try{
            subject.login(token);
            List<CourseType> courseTypeCountList=courseTypeService.listTotal();
            Session shiroSession = SecurityUtils.getSubject().getSession();
            session.setAttribute("currentUser",shiroSession.getAttribute("user"));//
            application.setAttribute("courseTypeCountList", courseTypeCountList);//
            return "redirect:/admin/main.jsp";
        }catch (Exception e ){
            session.setAttribute("user", user);
            request.setAttribute("error","账号或密码错误");
            e.printStackTrace();
            JSONObject result=new JSONObject();
            return "login";
        }
    }

    /**
     * 登出
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:../login.jsp";
    }
}
