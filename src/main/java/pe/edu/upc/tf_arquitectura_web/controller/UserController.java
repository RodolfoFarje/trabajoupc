package pe.edu.upc.tf_arquitectura_web.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pe.edu.upc.tf_arquitectura_web.dtos.UserDTO;
import pe.edu.upc.tf_arquitectura_web.dtos.UsuariosGeneroDTO;
import pe.edu.upc.tf_arquitectura_web.entities.Users;
import pe.edu.upc.tf_arquitectura_web.serviceinterfaces.IUserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService pS;
    @Autowired
    private PasswordEncoder bcrypt;

    @PostMapping
    public void registrar(@Valid Users user, Model model, SessionStatus status, @RequestBody UserDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Users p = m.map(dto, Users.class);
        String bcryptPassword=bcrypt.encode(p.getPassword());
        p.setPassword(bcryptPassword);
        pS.insert(p);
    }
    @PutMapping
    public void modificar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        Users p = m.map(dto, Users.class);
        pS.insert(p);

    }
    @GetMapping
    public List<UserDTO> listar(){
        return pS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,UserDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/username/{username}")
    public UserDTO ListUsername(@PathVariable("username")String name){
        ModelMapper m = new ModelMapper();
        UserDTO dto=m.map(pS.listUsername(name),UserDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Long id){pS.delete(id);}

    @GetMapping("/{id}")
    public UserDTO listId(@PathVariable("id") Long id){
        ModelMapper m = new ModelMapper();
        UserDTO dto = m.map(pS.listId(id), UserDTO.class);
        return dto;
    }
    @GetMapping("/cantidadporgenero")
    public List<UsuariosGeneroDTO> usuariosporgenero(){
        List<String[]> lista=pS.usuariosporgenero();
        List<UsuariosGeneroDTO> listaDTO=new ArrayList<>();
        for(String[] data:lista){
            UsuariosGeneroDTO dto=new UsuariosGeneroDTO();
            dto.setGenero(data[0]);
            dto.setContadorusuarios(Integer.parseInt(data[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
