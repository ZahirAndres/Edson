package mx.utng.edson.model.dao;
import java.util.List;

import mx.utng.edson.model.entity.Secundaria;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 17/04/2024
 */
public interface ISecundariaDao {
    List<Secundaria> list();
  void save(Secundaria secundaria);
  Secundaria getById(Long id);
  void delete(Long id);
}
