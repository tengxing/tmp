package online.edu.servive.impl;

import online.edu.entity.Course;
import online.edu.mapper.CourseMapper;
import online.edu.servive.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CourseServiceImpl extends InitServiceImpl<CourseMapper,Course> implements CourseService {
}
