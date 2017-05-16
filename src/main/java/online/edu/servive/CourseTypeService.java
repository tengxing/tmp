package online.edu.servive;

import online.edu.entity.CourseType;

import java.util.List;


public interface CourseTypeService extends InitService<CourseType> {

    public List<CourseType> listTotal();

}
