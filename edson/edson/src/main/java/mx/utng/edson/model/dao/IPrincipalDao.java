package mx.utng.edson.model.dao;
import java.util.List;

import mx.utng.edson.model.entity.Principal;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 17/04/2024
 */
public interface IPrincipalDao {

  List<Principal> list();
  void save(Principal principal);
  Principal getById(Long id);
  void delete(Long id);
  
} 