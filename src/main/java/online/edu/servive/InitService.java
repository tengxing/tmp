package online.edu.servive;

import online.edu.entity.InitModel;

import java.util.List;
import java.util.Map;

/**
 * Describe: curd
 */
public interface InitService<T extends InitModel> {
    List<T> list(Map<String,Object> map);
    List<T> listTotal();
    Integer saveOrUpdate(T var);
    T findById(Integer id);
    Integer deleteById(Integer id);
    Long getCount(Map<String,Object> map);
}
