package online.edu.controller.admin;

import net.sf.json.JSONObject;
import online.edu.entity.User;
import online.edu.servive.UserService;
import online.edu.util.DateUtil;
import online.edu.util.Md5Util;
import online.edu.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;


@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
    private static final Logger log = LoggerFactory.getLogger(AdminUserController.class);

    @Autowired
    UserService userService;


    @RequestMapping(value = "/find",method = RequestMethod.POST)
    public String find(HttpServletResponse response)throws Exception{
        User user = userService.find();
        JSONObject jsonObject=JSONObject.fromObject(user);
        ResponseUtil.write(response, jsonObject);
        return null;
    }


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestParam(value = "imageFile",required = false)MultipartFile imageFile, User user, HttpServletRequest request, HttpServletResponse response)throws Exception{
        if(!imageFile.isEmpty()){
            String filePath=request.getServletContext().getRealPath("/");
            String imageName= DateUtil.getCurrentDateStr()+"."+imageFile.getOriginalFilename().split("\\.")[1];
            imageFile.transferTo(new File(filePath+"static/userImages/"+imageName));
            user.setImageName(imageName);
        }
        int resultTotal=0;
        resultTotal = userService.update(user);
        StringBuffer result=new StringBuffer();
        if(resultTotal>0){
            result.append("<script language='javascript'>alert('修改成功！');</script>");
        }else{
            result.append("<script language='javascript'>alert('修改失败！');</script>");
        }
        return null;
    }

    /**
     * 更改密码
     * @param newPassword
     * @param response
     * @return
     */
    @RequestMapping(value = "/modifyPassword",method = RequestMethod.POST)
    public String modifyPassword(@RequestParam(value = "newPassword",required = true)String newPassword,
                                 HttpServletResponse response)throws Exception{
        int resultTotal=0;
        User user = new User();
        user.setPassword(Md5Util.md5(newPassword));
        resultTotal = userService.update(user);
        JSONObject result=new JSONObject();
        if(resultTotal>0){
            result.put("success",true);
        }else{
            result.put("success",false);
        }
        ResponseUtil.write(response,result);
        return null;
    }


}
