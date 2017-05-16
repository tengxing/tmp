package online.edu.servive.impl;

import online.edu.entity.InitModel;
import online.edu.mapper.InitMapper;
import online.edu.servive.InitService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Describe: serviceImpl
 */
public class InitServiceImpl<M extends InitMapper<T>,T extends InitModel> implements InitService<T> {

    @Autowired
    M initMapper;

    @Override
    public List<T> list(Map<String, Object> map) {
        return initMapper.list(map);
    }

    @Override
    public List<T> listTotal() {
        return initMapper.listTotal();
    }

    @Override
    public Integer saveOrUpdate(T var) {
        if(var.getId()==null){
            return initMapper.save(var);
        }else {
            return initMapper.update(var);
        }
    }

    @Override
    public T findById(Integer id) {
        return initMapper.findById(id);
    }

    @Override
    public Integer deleteById(Integer id) {
        return initMapper.deleteById(id);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return initMapper.getCount(map);
    }
}
