package mx.utng.edson.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.edson.model.entity.SubSecu;

@Repository
public class ISubSecuDaoImpl implements ISubSecuDao {
    @Autowired
private EntityManager em;


    @Override
    public List<SubSecu> list() {
        
        return em.createQuery("from SubSecu", SubSecu.class).getResultList();
    }
    @Override
    public void save(SubSecu subSecu) {
        if(subSecu.getId()!= null && subSecu.getId()>0){

            em.merge(subSecu);
        }else{
            em.persist(subSecu);
        }
        
    }
    @Override
    public SubSecu getById(Long id) {
        return em.find(SubSecu.class, id);
    }
    @Override
    public void delete(Long id) {
        SubSecu subSecu = getById(id);
        em.remove(subSecu);
    }
    
}
