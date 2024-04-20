package mx.utng.edson.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.edson.model.dao.ISecundariaDao;
import mx.utng.edson.model.entity.Secundaria;

@Service
public class ISecundariaServiceImpl implements ISecundariaService{

    @Autowired
    private ISecundariaDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<Secundaria> list() {
        return dao.list();
    }
    @Transactional
    @Override
    public void save(Secundaria secundaria) {
    dao.save(secundaria);    
    }
    @Transactional(readOnly = true)
    @Override
    public Secundaria getByID(Long id) {
        return dao.getById(id);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
    
}
