package online.edu.servive.impl;

import online.edu.entity.CourseType;
import online.edu.mapper.CourseTypeMapper;
import online.edu.servive.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseTypeServiceImpl extends InitServiceImpl<CourseTypeMapper,CourseType> implements CourseTypeService {

    @Autowired
    CourseTypeMapper courseTypeMapper;

    @Override
    public List<CourseType> listTotal() {
        return courseTypeMapper.listTotal();
    }
}
