package pe.edu.upc.tf_arquitectura_web.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tf_arquitectura_web.entities.Role;
import pe.edu.upc.tf_arquitectura_web.entities.Users;
import pe.edu.upc.tf_arquitectura_web.repositories.IAdministradorRepository;
import pe.edu.upc.tf_arquitectura_web.repositories.UserRepository;
import pe.edu.upc.tf_arquitectura_web.serviceinterfaces.IUserService;

import java.util.Collections;
import java.util.List;
@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private UserRepository pR;
    private IAdministradorRepository aR;
    @Override
    public Users listUsername(String name){
        return pR.findByUsername(name);
    }

    @Override
    public void insert(Users users) {
        String rol=users.getRol();
        Role role=new Role();
        if("ADMIN".equals(rol)){
            role.setRol("ADMIN");
            role.setUser(users);
            users.setRoles(Collections.singletonList(role));
            pR.save(users);

        }
        if("USER".equals(rol)){
            role.setRol("USER");
            role.setUser(users);
            users.setRoles(Collections.singletonList(role));
            pR.save(users);
        }

    }
    @Override
    public List<Users> list(){return pR.findAll();}

    @Override
    public void delete(Long id) {pR.deleteById(id);}

    @Override
    public Users listId(Long id) {
        return pR.findById(id).orElse(new Users());
    }
    @Override
    public List<String[]> usuariosporgenero(){return pR.usuariosporgenero();}

}
