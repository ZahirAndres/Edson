package mx.utng.edson.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 17/04/2024
 */
import jakarta.persistence.EntityManager;
import mx.utng.edson.model.entity.Secundaria;

@Repository
public class ISecundariaDaoImpl implements ISecundariaDao {
    @Autowired
private EntityManager em;


    @Override
    public List<Secundaria> list() {
        
        return em.createQuery("from Secundaria", Secundaria.class).getResultList();
    }
    @Override
    public void save(Secundaria secundaria) {
        if(secundaria.getId()!= null && secundaria.getId()>0){

            em.merge(secundaria);
        }else{
            em.persist(secundaria);
        }
        
    }
    @Override
    public Secundaria getById(Long id) {
        return em.find(Secundaria.class, id);
    }
    @Override
    public void delete(Long id) {
        Secundaria secundaria = getById(id);
        em.remove(secundaria);
    }
    
}
