package online.edu.controller;

import com.alibaba.fastjson.JSONObject;
import online.edu.entity.Student;
import online.edu.servive.StudentService;
import online.edu.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/stu")
public class Ffsdf {

    @Autowired
    StudentService studentService;

    

    @RequestMapping("/save")
    public String test(Student student, HttpServletResponse response){

        int resultTotal = 0;
        try {
            resultTotal = studentService.saveOrUpdate(student);
            JSONObject result = new JSONObject();


            System.out.println(resultTotal);
            if (resultTotal > 0) {
                result.put("success", true);
            } else {
                result.put("success", false);
            }
            ResponseUtil.write(response, result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
