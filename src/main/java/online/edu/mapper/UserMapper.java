package online.edu.mapper;

import online.edu.entity.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {

    public User find();

    public User findByUserName(String userName);

    public void update(User user);
}
