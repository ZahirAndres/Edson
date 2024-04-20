package mx.utng.edson.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.edson.model.dao.ISubSecuDao;
import mx.utng.edson.model.entity.SubSecu;

@Service
public class ISubSecuServiceImpl implements ISubSecuService{

    @Autowired
    private ISubSecuDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<SubSecu> list() {
        return dao.list();
    }
    @Transactional
    @Override
    public void save(SubSecu subSecu) {
    dao.save(subSecu);    
    }
    @Transactional(readOnly = true)
    @Override
    public SubSecu getByID(Long id) {
        return dao.getById(id);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
    
}
