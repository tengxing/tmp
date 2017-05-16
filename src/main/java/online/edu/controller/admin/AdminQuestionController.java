package online.edu.controller.admin;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import online.edu.entity.Question;
import online.edu.entity.Student;
import online.edu.mapper.QuestionMapper;
import online.edu.util.PageBean;
import online.edu.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/ques")
public class AdminQuestionController {

    @Autowired
    QuestionMapper questionMapper;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Question courseType, HttpServletResponse response)throws Exception{
        System.out.println("dfdf");
        int resultTotal = 0;
        try {
            if(courseType.getId()==null) {
                resultTotal = questionMapper.save(courseType);
            }else {
                resultTotal = questionMapper.update(courseType);
            }
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

    @RequestMapping("/list")
    String list(@RequestParam(value = "page",required = false)String page, @RequestParam(value = "rows",required = false)String rows,
                HttpServletResponse response)throws Exception{
        PageBean pageBean =new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map = new HashMap();
        map.put("start",pageBean.getStart());
        map.put("size",pageBean.getPageSize());

        List<Question> blogTypeList =questionMapper.list(map);
        Long total = questionMapper.getCount(map);
        JSONObject result = new JSONObject();
        //集合不能直接转JSONArray
        String typeString = JSON.toJSONString(blogTypeList);
        JSONArray jsonArray = JSONArray.parseArray(typeString);
        result.put("rows",jsonArray);
        result.put("total",total);
        ResponseUtil.write(response,result);
        return null;
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam(value = "ids",required = true)String ids, HttpServletResponse response)throws Exception{
        String []idsStr = ids.split(",");
        for (int i=0;i<idsStr.length;i++) {
            questionMapper.deleteById(Integer.parseInt(idsStr[i]));
        }
        JSONObject result = new JSONObject();
        result.put("success",true);
        ResponseUtil.write(response,result);
        return null;
    }
}
