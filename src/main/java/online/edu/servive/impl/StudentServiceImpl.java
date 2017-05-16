package online.edu.servive.impl;

import online.edu.entity.Student;
import online.edu.mapper.StudentMapper;
import online.edu.servive.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl extends InitServiceImpl<StudentMapper, Student> implements StudentService {
}
