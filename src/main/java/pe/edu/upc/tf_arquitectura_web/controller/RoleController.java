package pe.edu.upc.tf_arquitectura_web.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tf_arquitectura_web.dtos.RoleDTO;
import pe.edu.upc.tf_arquitectura_web.entities.Role;
import pe.edu.upc.tf_arquitectura_web.serviceinterfaces.IRoleService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService pS;

    @PostMapping
    public void registrar(@RequestBody RoleDTO dto) {
        ModelMapper m = new ModelMapper();
        Role p = m.map(dto, Role.class);
        pS.insert(p);

    }
    @PutMapping
    public void modificar(@RequestBody RoleDTO dto) {
        ModelMapper m = new ModelMapper();
        Role p = m.map(dto, Role.class);
        pS.insert(p);

    }
    @GetMapping
    public List<RoleDTO> listar(){
        return pS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RoleDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Long id){pS.delete(id);}

    @GetMapping("/{id}")
    public RoleDTO listId(@PathVariable("id") Long id){
        ModelMapper m = new ModelMapper();
        RoleDTO dto = m.map(pS.listId(id), RoleDTO.class);
        return dto;
    }

}
