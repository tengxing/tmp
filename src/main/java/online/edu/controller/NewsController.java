package online.edu.controller;

import net.sf.json.JsonConfig;
import online.edu.entity.Gonggao;
import online.edu.mapper.GonggaoMapper;
import online.edu.servive.NewService;
import online.edu.entity.New;
import online.edu.util.DateJsonValueProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {


    @Autowired
    NewService fameService;

    @Autowired
    GonggaoMapper gonggaoMapper;

    @RequestMapping("/{id}")
    public ModelAndView tst(@PathVariable(value = "id")Integer id){
        ModelAndView mv = new ModelAndView();
        List<New> fameList = fameService.listTotal();

        if(id==1){
            mv.addObject("myFametype","公司新闻");
        }else {
            mv.addObject("myFametype","行业资讯");
        }

        mv.addObject("myFameList",fameList);

        mv.setViewName("front/news");
        return  mv;
    }

    @RequestMapping("last")
    public ModelAndView last(){
        ModelAndView mv = new ModelAndView();
        List<Gonggao> fameList = gonggaoMapper.listTotal();
        mv.addObject("newsList",fameList);
        mv.setViewName("front/last");
        return mv;
    }
}
