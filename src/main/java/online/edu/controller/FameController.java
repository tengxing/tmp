package online.edu.controller;

import online.edu.entity.Fame;
import online.edu.servive.FameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/fame")
public class FameController {


    @Autowired
    FameService fameService;

    @RequestMapping("/{id}")
    public ModelAndView tst(@PathVariable(value = "id")Integer id){
        ModelAndView mv = new ModelAndView();
        List<Fame> fameList = fameService.listTotal();

        if(id==1){
            mv.addObject("myFametype","家长见证");
        }else {
            mv.addObject("myFametype","下载中心");
        }
        mv.addObject("myFameList",fameList);

        mv.setViewName("front/fame");
        return  mv;
    }
}
