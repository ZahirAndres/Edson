package mx.utng.edson.model.service;

import java.util.List;

import mx.utng.edson.model.entity.Principal;

public interface IPrincipalService {
    List<Principal> list();
    void save(Principal principal);
    Principal getByID(Long id);
    void delete(Long id);
}
