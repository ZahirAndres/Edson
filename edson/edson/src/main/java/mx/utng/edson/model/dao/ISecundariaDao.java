package mx.utng.edson.model.dao;
import java.util.List;

import mx.utng.edson.model.entity.Secundaria;

public interface ISecundariaDao {
    List<Secundaria> list();
  void save(Secundaria secundaria);
  Secundaria getById(Long id);
  void delete(Long id);
}
