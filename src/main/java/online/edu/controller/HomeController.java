package online.edu.controller;

import online.edu.entity.New;
import online.edu.entity.Teacher;
import online.edu.mapper.TeacherMapper;
import online.edu.servive.CourseService;
import online.edu.servive.FameService;
import online.edu.entity.Course;
import online.edu.entity.Fame;
import online.edu.servive.NewService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    private Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    CourseService courseService;

    @Autowired
    FameService fameService;

    @Autowired
    NewService newService;

    @Autowired
    TeacherMapper teacherMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String get(HttpServletRequest request){

        ServletContext application= RequestContextUtils.getWebApplicationContext(request).getServletContext();
        //课程

        List<Course> courseList = courseService.listTotal();

        List<Fame> fameList = fameService.listTotal();

        List<Teacher> teacherList = teacherMapper.listTotal();

        List<Teacher> teacherFour = new LinkedList<Teacher>();


        List<Course> firstFour = new LinkedList<Course>();

        for(int i=0;i<4;i++){
            firstFour.add(courseList.get(i));
            teacherFour.add(teacherList.get(i));
        }

        List<New> listNew = newService.listTotal();
        application.setAttribute("newsList",listNew);
        application.setAttribute("teacherFour",teacherFour);
        application.setAttribute("courseFour",firstFour);
        application.setAttribute("fameList",fameList);

        application.setAttribute("courseList",courseList);
        return "front/index";
    }
    @RequestMapping("/index")
    public ModelAndView home(HttpSession session, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        ServletContext application= RequestContextUtils.getWebApplicationContext(request).getServletContext();
        //课程

        List<Course> courseList = courseService.listTotal();

        List<Fame> fameList = fameService.listTotal();

        application.setAttribute("fameList",fameList);

        application.setAttribute("courseList",courseList);

        mv.setViewName("front/home");
        return mv;
    }

    @RequestMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable(value = "id")Integer id, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("");
        System.out.println(path);
        String na = fameService.findById(id).getUrl();
        String pathname = path+na;
        System.out.println(pathname);
        File file=new File(pathname);
        HttpHeaders headers = new HttpHeaders();
        //String fileName=new String("你好.xlsx".getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment",na);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

}
