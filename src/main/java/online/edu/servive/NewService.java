package online.edu.servive;

import online.edu.entity.New;

import java.util.Map;


public interface NewService extends InitService<New> {
    Long getTotal(Map<String,Object> map);

}
