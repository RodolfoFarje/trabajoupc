package pe.edu.upc.tf_arquitectura_web.serviceinterfaces;

import pe.edu.upc.tf_arquitectura_web.entities.Role;

import java.util.List;

public interface IRoleService {
    public void insert(Role role);
    public List<Role> list();
    public void delete(Long id);
    public Role listId(Long id);
}
