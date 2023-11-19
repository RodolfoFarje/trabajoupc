package pe.edu.upc.tf_arquitectura_web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.tf_arquitectura_web.entities.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {
}
