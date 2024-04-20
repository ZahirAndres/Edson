package mx.utng.edson.model.service;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 17/04/2024
 */
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.edson.model.dao.IPrincipalDao;
import mx.utng.edson.model.entity.Principal;

@Service
public class IPrincipalServiceImpl implements IPrincipalService{

    @Autowired
    private IPrincipalDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<Principal> list() {
        return dao.list();
    }
    @Transactional
    @Override
    public void save(Principal principal) {
    dao.save(principal);    
    }
    @Transactional(readOnly = true)
    @Override
    public Principal getByID(Long id) {
        return dao.getById(id);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}
