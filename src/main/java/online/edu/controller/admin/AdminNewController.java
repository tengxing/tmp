package online.edu.controller.admin;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import online.edu.entity.New;
import online.edu.servive.NewService;
import online.edu.util.DateJsonValueProcessor;
import online.edu.util.PageBean;
import online.edu.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/admin/new")
public class AdminNewController {

    Logger log = LoggerFactory.getLogger(AdminNewController.class);

    @Autowired
    NewService newService;

    /**
     * 新闻李彪
     * @param page
     * @param rows
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public String list(@RequestParam(value = "page",required = false)String page,
                       @RequestParam(value = "rows",required = false)String rows,
                       HttpServletResponse response)throws Exception{
        PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("start",pageBean.getStart());
        map.put("size",pageBean.getPageSize());
        List<New> list = newService.list(map);
        log.info("list:"+list.toString());
        Long total = newService.getCount(map);
        net.sf.json.JSONObject result=new net.sf.json.JSONObject();
        JsonConfig jsonConfig=new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        net.sf.json.JSONArray jsonArray= net.sf.json.JSONArray.fromObject(list,jsonConfig);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 通过id找新闻
     * @param id
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public String findById(@RequestParam(value = "id")String id,HttpServletResponse response)throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        New news = newService.findById(Integer.parseInt(id));
        JSONObject result = JSONObject.fromObject(news);
        ResponseUtil.write(response,result);
        return null;
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(New news, HttpServletResponse response)throws Exception{
        news.setReleaseDate(new Date());
        log.info(news.toString());
        int resultTotal=0;
        try {
            resultTotal = newService.saveOrUpdate(news);
            JSONObject result = new JSONObject();
            if (resultTotal == 1) {
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

    /**
     * 删除博客
     * @param ids
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam(value = "ids",required = true)String ids, HttpServletResponse response)throws Exception{
        String []idsStr = ids.split(",");
        for (int i=0;i<idsStr.length;i++) {
            newService.deleteById(Integer.parseInt(idsStr[i]));
        }
        JSONObject result = new JSONObject();
        result.put("success",true);
        ResponseUtil.write(response,result);
        return null;
    }
}
