package online.edu.servive.impl;

import online.edu.entity.User;
import online.edu.mapper.UserMapper;
import online.edu.servive.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User find() {
        return userMapper.find() ;
    }

    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    @Override
    public Integer update(User user) {
        try {
            userMapper.update(user);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
