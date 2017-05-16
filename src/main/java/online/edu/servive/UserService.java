package online.edu.servive;

import online.edu.entity.User;

public interface UserService {
    /**
     * 查询
     * @return
     */
    public User find();

    public User findByUserName(String userName);


    public Integer update(User user);

}
