package online.edu.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import net.sf.json.JSONObject;
import online.edu.entity.Fame;
import online.edu.servive.FameService;
import online.edu.util.PageBean;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/admin/fame")
public class AdminFameController {
    Logger log = LoggerFactory.getLogger(AdminFameController.class);

    @Autowired
    FameService fameService;

    @RequestMapping("/list")
    String list(@RequestParam(value = "page",required = false)String page, @RequestParam(value = "rows",required = false)String rows,
                HttpServletResponse response)throws Exception{
        log.info("page:"+page);
        PageBean pageBean =new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map = new HashMap();
        map.put("start",pageBean.getStart());
        map.put("size",pageBean.getPageSize());
        log.info(map.toString());
        List<Fame> blogTypeList =fameService.list(map);
        Long total = fameService.getCount(map);
        com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject();
        //集合不能直接转JSONArray
        String typeString = JSON.toJSONString(blogTypeList);
        JSONArray jsonArray = JSONArray.parseArray(typeString);
        result.put("rows",jsonArray);
        result.put("total",total);
        log.info(result.toString());
        ResponseUtil.write(response,result);
        return null;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(HttpServletRequest request, @RequestParam(value = "file" ,required = false) MultipartFile file, Fame fame, HttpServletResponse response)throws Exception{
        log.info(file.toString());
        log.info(fame.toString());
        Integer resultTotal;
        String path = request.getSession().getServletContext().getRealPath("/upload");
        String fileName = file.getOriginalFilename();
        //        String fileName = new Date().getTime()+".jpg";
        String url ="/upload/"+fileName;
        System.out.println(url);
        fame.setUrl(url);
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("写入文件："+url);
        try {
            resultTotal = fameService.saveOrUpdate(fame);
            JSONObject result = new JSONObject();
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

    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "ids")String ids,HttpServletResponse response)throws Exception{
        String []idsStr=ids.split(",");
        //此处应该判断blog是否属于该类型
        com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject();
        for (int i=0;i<idsStr.length;i++) {
            fameService.deleteById(Integer.parseInt(idsStr[i]));
        }
        result.put("success",true);
        ResponseUtil.write(response,result);
        return null;
    }

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public String findById(@RequestParam(value = "id")String id,HttpServletResponse response)throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        Fame message = fameService.findById(Integer.parseInt(id));
        JSONObject result = JSONObject.fromObject(message);
        ResponseUtil.write(response,result);
        return null;
    }

}
