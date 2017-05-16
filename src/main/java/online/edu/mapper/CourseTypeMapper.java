package online.edu.mapper;

import online.edu.entity.CourseType;

import java.util.List;


public interface CourseTypeMapper extends InitMapper<CourseType> {

    List<CourseType> listTotal();
}
