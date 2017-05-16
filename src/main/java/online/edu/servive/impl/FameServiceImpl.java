package online.edu.servive.impl;

import online.edu.entity.Fame;
import online.edu.servive.FameService;
import online.edu.mapper.FameMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class FameServiceImpl extends InitServiceImpl<FameMapper,Fame> implements FameService {
}
