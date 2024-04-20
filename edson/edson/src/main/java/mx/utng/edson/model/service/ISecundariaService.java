package mx.utng.edson.model.service;
import java.util.List;

import mx.utng.edson.model.entity.Secundaria;

public interface ISecundariaService {
    List<Secundaria> list();
    void save(Secundaria secundaria);
    Secundaria getByID(Long id);
    void delete(Long id);
}
