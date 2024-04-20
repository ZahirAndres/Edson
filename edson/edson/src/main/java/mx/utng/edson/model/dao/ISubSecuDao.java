package mx.utng.edson.model.dao;
import java.util.List;

import mx.utng.edson.model.entity.SubSecu;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 17/04/2024
 */
public interface ISubSecuDao {
    List<SubSecu> list();
  void save(SubSecu subSecu);
  SubSecu getById(Long id);
  void delete(Long id);
}
