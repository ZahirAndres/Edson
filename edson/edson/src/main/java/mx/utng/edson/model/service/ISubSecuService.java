package mx.utng.edson.model.service;
import java.util.List;

import mx.utng.edson.model.entity.SubSecu;

public interface ISubSecuService {
    List<SubSecu> list();
    void save(SubSecu subSecu);
    SubSecu getByID(Long id);
    void delete(Long id);
}
