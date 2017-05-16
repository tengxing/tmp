package online.edu.controller.admin;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import online.edu.entity.Gonggao;
import online.edu.entity.Question;
import online.edu.entity.Teacher;
import online.edu.mapper.GonggaoMapper;
import online.edu.util.PageBean;
import online.edu.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/gonggao")
public class AdminCOntrooer {

    @Autowired
    GonggaoMapper gonggaoMapper;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(HttpServletRequest request, @RequestParam(value = "file" ,required = false) MultipartFile file, Gonggao teacher, HttpServletResponse response)throws Exception{
        Integer resultTotal;
        String path = request.getSession().getServletContext().getRealPath("/upload");
        String fileName = file.getOriginalFilename();
        //        String fileName = new Date().getTime()+".jpg";
        String url ="/upload/"+fileName;
        System.out.println(url);
        teacher.setUrl(url);
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            resultTotal = gonggaoMapper.save(teacher);
            net.sf.json.JSONObject result = new net.sf.json.JSONObject();
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

        List<Gonggao> blogTypeList =gonggaoMapper.list(map);
        Long total = gonggaoMapper.getCount(map);
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
            gonggaoMapper.deleteById(Integer.parseInt(idsStr[i]));
        }
        JSONObject result = new JSONObject();
        result.put("success",true);
        ResponseUtil.write(response,result);
        return null;
    }


}
