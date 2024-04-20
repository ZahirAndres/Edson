package mx.utng.edson.model.dao;
import java.util.List;

import mx.utng.edson.model.entity.SubSecu;

public interface ISubSecuDao {
    List<SubSecu> list();
  void save(SubSecu subSecu);
  SubSecu getById(Long id);
  void delete(Long id);
}
