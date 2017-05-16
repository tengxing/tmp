package online.edu.servive;

import online.edu.entity.Sign;
import online.edu.mapper.SignMapper;
import online.edu.servive.impl.InitServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SignServiceImpl extends InitServiceImpl<SignMapper, Sign> implements SignService{
}
