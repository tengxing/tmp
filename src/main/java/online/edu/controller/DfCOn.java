package online.edu.controller;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import online.edu.entity.Message;
import online.edu.servive.MessageService;
import online.edu.util.ResponseUtil;

@Controller
@RequestMapping("/message")
public class DfCOn {

    @Autowired
    MessageService messageMapper;

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public ModelAndView tet(){
    	ModelAndView mv = new ModelAndView();
        System.out.println("fsdfsdf");
        mv.setViewName("/front/mess");
        List<Message> list = messageMapper.listTotal();
        mv.addObject("messageList",list);
        return mv;
       
    }

    @RequestMapping("/save")
    public String fds(Message message, HttpServletResponse response){
        message.setMessageTime(new Date());
        System.out.println(message.toString());
        int resultTotal = 0;
        try {
            resultTotal=  messageMapper.saveOrUpdate(message);
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
}
