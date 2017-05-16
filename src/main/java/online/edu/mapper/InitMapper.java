package online.edu.mapper;


import java.util.List;
import java.util.Map;

/**
 * Describe: 常用方法
 */
public interface InitMapper<T> {

    List<T> list(Map<String,Object> map);
    List<T> listTotal();
    T findById(Integer id);
    Integer deleteById(Integer id);
    Integer save(T var);
    Integer update(T var);
    Long getCount(Map<String,Object> map);

}
