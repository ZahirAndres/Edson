package mx.utng.edson.model.service;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 17/04/2024
 */
import java.util.List;

import mx.utng.edson.model.entity.Principal;

public interface IPrincipalService {
    List<Principal> list();
    void save(Principal principal);
    Principal getByID(Long id);
    void delete(Long id);
}
