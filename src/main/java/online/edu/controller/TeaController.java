package online.edu.controller;

import online.edu.entity.Teacher;
import online.edu.servive.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/tea")
public class TeaController {

    @Autowired
    TeaService teamService;

    @RequestMapping("/{id}")
    public ModelAndView tst(@PathVariable(value = "id")Integer id){
        ModelAndView mv = new ModelAndView();
        List<Teacher> fameList = teamService.listTotal();

        if(id==1){
            mv.addObject("myFametype","专家团队");
        }else {
            mv.addObject("myFametype","师资力量");
        }
        mv.addObject("myFameList",fameList);

        mv.setViewName("front/teacher");
        return  mv;
    }
}
