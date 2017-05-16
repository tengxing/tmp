package online.edu.servive.impl;

import online.edu.entity.Teacher;
import online.edu.mapper.TeacherMapper;
import online.edu.servive.TeaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeaServiceImpl  extends InitServiceImpl<TeacherMapper,Teacher> implements TeaService {
}
