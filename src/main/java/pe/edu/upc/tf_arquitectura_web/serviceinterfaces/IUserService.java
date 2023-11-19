package pe.edu.upc.tf_arquitectura_web.serviceinterfaces;

import pe.edu.upc.tf_arquitectura_web.entities.Role;
import pe.edu.upc.tf_arquitectura_web.entities.Users;

import java.util.List;

public interface IUserService {
    public void insert(Users role);
    public List<Users> list();
    public void delete(Long id);
    public Users listId(Long id);
    public Users listUsername(String name);

    List<String[]> usuariosporgenero();
}
