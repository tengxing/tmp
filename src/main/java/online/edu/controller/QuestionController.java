package online.edu.controller;


import online.edu.mapper.QuestionMapper;
import online.edu.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/ques")
public class QuestionController {

    @Autowired
    QuestionMapper questionMapper;

    @RequestMapping("/list")
    public ModelAndView last(){
        ModelAndView mv = new ModelAndView();
        List<Question> fameList = questionMapper.listTotal();
        mv.addObject("quesList",fameList);
        mv.setViewName("front/ques");
        return mv;
    }


}
