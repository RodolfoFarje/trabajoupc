package pe.edu.upc.tf_arquitectura_web.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tf_arquitectura_web.entities.Profesores;
import pe.edu.upc.tf_arquitectura_web.entities.Role;
import pe.edu.upc.tf_arquitectura_web.repositories.IProfesoresRepository;
import pe.edu.upc.tf_arquitectura_web.repositories.IRoleRepository;
import pe.edu.upc.tf_arquitectura_web.serviceinterfaces.IRoleService;

import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService {
    @Autowired
    private IRoleRepository pR;

    @Override
    public void insert(Role profesores) {pR.save(profesores);}
    @Override
    public List<Role> list(){return pR.findAll();}

    @Override
    public void delete(Long id) {pR.deleteById(id);}

    @Override
    public Role listId(Long id) { return null;}


}
