package online.edu.controller.admin;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import online.edu.entity.Message;
import online.edu.servive.MessageService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin/message")
public class AdminMessageController {

    private static final Logger log = LoggerFactory.getLogger(AdminMessageController.class);

    @Autowired
    MessageService messageService;


    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public String list(@RequestParam(value = "page",required = false)String page,
                       @RequestParam(value = "rows",required = false)String rows,
                       HttpServletResponse response)throws Exception{
        PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("start",pageBean.getStart());
        map.put("size",pageBean.getPageSize());
        try {
            List<Message> list = messageService.list(map);
            log.info("list:"+list.toString());
        Long total = messageService.getCount(map);
            net.sf.json.JSONObject result=new net.sf.json.JSONObject();
        JsonConfig jsonConfig=new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        net.sf.json.JSONArray jsonArray= net.sf.json.JSONArray.fromObject(list,jsonConfig);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/lastday",method = RequestMethod.POST)
    public String lastday(@RequestParam(value = "page",required = false)String page,
                       @RequestParam(value = "rows",required = false)String rows,
                       HttpServletResponse response)throws Exception{
        PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("start",pageBean.getStart());
        map.put("size",pageBean.getPageSize());
        map.put("messageTime",7);
        try {
            List<Message> list = messageService.list(map);
            log.info("list:"+list.toString());
            Long total = messageService.getCount(map);
            net.sf.json.JSONObject result=new net.sf.json.JSONObject();
            JsonConfig jsonConfig=new JsonConfig();
            jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
            net.sf.json.JSONArray jsonArray= net.sf.json.JSONArray.fromObject(list,jsonConfig);
            result.put("rows", jsonArray);
            result.put("total", total);
            ResponseUtil.write(response, result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public String findById(@RequestParam(value = "id")String id,HttpServletResponse response)throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        Message message = messageService.findById(Integer.parseInt(id));
        JSONObject result = JSONObject.fromObject(message);
        ResponseUtil.write(response,result);
        return null;
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Message message, HttpServletResponse response)throws Exception{
        log.info(message.toString());
        Integer resultTotal;
        resultTotal = messageService.saveOrUpdate(message);
        JSONObject result = new JSONObject();
        if(resultTotal==1){
            result.put("success",true);
        }else {
            result.put("success",false);
        }
        ResponseUtil.write(response,result);
        return null;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam(value = "ids",required = true)String ids, HttpServletResponse response)throws Exception{
        String []idsStr = ids.split(",");
        for (int i=0;i<idsStr.length;i++) {
            messageService.deleteById(Integer.parseInt(idsStr[i]));
        }
        JSONObject result = new JSONObject();
        result.put("success",true);
        ResponseUtil.write(response,result);
        return null;
    }
    @RequestMapping(value = "/update", method= RequestMethod.POST)
    public String update(@RequestParam(value = "id",required = true)String id, @RequestParam(value = "status")String status, HttpServletResponse response)throws Exception{
      
        Integer resultTotal=0;
        try {
           
                Message message = messageService.findById(Integer.parseInt(id));
                message.setStatus(status);
                resultTotal = messageService.saveOrUpdate(message);
            
            JSONObject result = new JSONObject();
            if (resultTotal == 1) {
                result.put("success", true);
            } else {
                result.put("success", false);
            }
            ResponseUtil.write(response, result);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
