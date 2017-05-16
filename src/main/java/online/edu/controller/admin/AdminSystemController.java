package online.edu.controller.admin;

import net.sf.json.JSONObject;
import online.edu.entity.*;

import online.edu.servive.CourseTypeService;
import online.edu.servive.UserService;
import online.edu.util.ResponseUtil;
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
@RequestMapping("/admin/system")
public class AdminSystemController {


    @Autowired
    UserService userService;

    @Autowired
    CourseTypeService blogTypeService;

    /**
     * 刷新缓存
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/refresh")
    public String refreshSystem(HttpServletResponse response, HttpSession session, HttpServletRequest request)throws Exception{
        ServletContext application= RequestContextUtils.getWebApplicationContext(request).getServletContext();
        User user = userService.find();
        user.setPassword(null);
        session.setAttribute("user", user);

        List<CourseType> blogTypeCountList=blogTypeService.listTotal();
        application.setAttribute("CourseTypeCountList", blogTypeCountList);

        JSONObject result=new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }
}
