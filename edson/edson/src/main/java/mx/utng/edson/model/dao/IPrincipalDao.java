package mx.utng.edson.model.dao;
import java.util.List;

import mx.utng.edson.model.entity.Principal;

public interface IPrincipalDao {

  List<Principal> list();
  void save(Principal principal);
  Principal getById(Long id);
  void delete(Long id);
  
} 
