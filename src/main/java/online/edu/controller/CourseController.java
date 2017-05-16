package online.edu.controller;

import online.edu.servive.CourseService;
import online.edu.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String RR(){
        return "front/course";
    }

    @RequestMapping("/{id}")
    ModelAndView artitle(@PathVariable("id")Integer id){
        System.out.println(id);
        ModelAndView mv = new ModelAndView();
        Course course = courseService.findById(id);
        mv.addObject("course",course);
        mv.setViewName("front/course");
        return mv;
    }
}
