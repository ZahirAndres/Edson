package mx.utng.edson.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.edson.model.entity.Principal;
@Repository
public class IPrincipalDaoImpl implements IPrincipalDao{
@Autowired
private EntityManager em;


    @Override
    public List<Principal> list() {
        
        return em.createQuery("from Principal", Principal.class).getResultList();
    }
    @Override
    public void save(Principal principal) {
        if(principal.getId()!= null && principal.getId()>0){
            em.merge(principal);
        }else{
            em.persist(principal);
        }
        
    }
    @Override
    public Principal getById(Long id) {
        return em.find(Principal.class, id);
    }
    @Override
    public void delete(Long id) {
        Principal principal = getById(id);
        em.remove(principal);
    }
    
}
