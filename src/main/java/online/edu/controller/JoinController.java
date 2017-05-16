package online.edu.controller;

import online.edu.entity.Sign;
import online.edu.servive.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/join")
public class JoinController {

    @Autowired
    SignService signService;
    @RequestMapping("/{id}")
    public ModelAndView tst(@PathVariable(value = "id")Integer id){
        ModelAndView mv = new ModelAndView();
        Sign sign = signService.findById(id);
        mv.addObject("sign",sign);
        mv.setViewName("front/join");
        if(id>4){
            mv.setViewName("front/us");
        }
        return  mv;
    }


}
