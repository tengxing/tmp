package online.edu.mapper;

import online.edu.entity.New;

import java.util.Map;


public interface NewMapper extends InitMapper<New>{

    Long getTotal(Map<String,Object> map);
}
