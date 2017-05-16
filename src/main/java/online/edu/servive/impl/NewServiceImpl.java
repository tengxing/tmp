package online.edu.servive.impl;

import online.edu.entity.New;
import online.edu.mapper.NewMapper;
import online.edu.servive.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class NewServiceImpl extends InitServiceImpl<NewMapper,New> implements NewService {

    @Autowired
    NewMapper newMapper;

    @Override
    public Long getTotal(Map<String, Object> map) {
        return newMapper.getTotal(map);
    }
}
