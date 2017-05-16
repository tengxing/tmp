package online.edu.controller;

import online.edu.entity.New;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/mv")
public class MvController {

    @RequestMapping("/{id}")
    public ModelAndView tst(@PathVariable(value = "id")Integer id){
        ModelAndView mv = new ModelAndView();


        if(id==1){
            mv.addObject("myFametype","视频分享");
        }else {
            mv.addObject("myFametype","视频下载");
        }
        mv.addObject("url","http://player.youku.com/embed/XMjc0NDgwMTg4OA==");

        mv.setViewName("front/mv");
        return  mv;
    }
}
