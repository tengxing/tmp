package online.edu.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import online.edu.entity.CourseType;
import online.edu.util.PageBean;
import online.edu.util.ResponseUtil;
import online.edu.servive.CourseTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/admin/courseType")
public class AdminCourseTypeController {

    private  static final Logger log = LoggerFactory.getLogger(AdminCourseTypeController.class);

    @Autowired
    private CourseTypeService courseTypeService;

    /**
     * 类别分页
     * @param page
     * @param rows
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    String list(@RequestParam(value = "page",required = false)String page, @RequestParam(value = "rows",required = false)String rows,
                HttpServletResponse response)throws Exception{
        log.info("page:"+page);
        PageBean pageBean =new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map = new HashMap();
        map.put("start",pageBean.getStart());
        map.put("size",pageBean.getPageSize());
        log.info(map.toString());
        List<CourseType> blogTypeList =courseTypeService.list(map);
        Long total = courseTypeService.getCount(map);
        JSONObject result = new JSONObject();
        //集合不能直接转JSONArray
        String typeString = JSON.toJSONString(blogTypeList);
        JSONArray jsonArray = JSONArray.parseArray(typeString);
        result.put("rows",jsonArray);
        result.put("total",total);
        log.info(result.toString());
        ResponseUtil.write(response,result);
        return null;
    }

    /**
     * 删除类别
     * @param ids
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "ids")String ids,HttpServletResponse response)throws Exception{
        String []idsStr=ids.split(",");
        //此处应该判断blog是否属于该类型
        JSONObject result = new JSONObject();
        for (int i=0;i<idsStr.length;i++) {
            courseTypeService.deleteById(Integer.parseInt(idsStr[i]));
        }
        result.put("success",true);
        ResponseUtil.write(response,result);
        return null;
    }

    /**
     * 保存或更新类别
     * @param CourseType
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public String save(CourseType courseType,HttpServletResponse response)throws Exception{

        int resultTotal = 0;
        try {
            resultTotal = courseTypeService.saveOrUpdate(courseType);
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
