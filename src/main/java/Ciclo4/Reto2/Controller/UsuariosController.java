/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo4.Reto2.Controller;

import Ciclo4.Reto2.Modelo.Usuarios;
import Ciclo4.Reto2.Services.UsuariosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user")
@CrossOrigin
/**
 *Clase principal
 */
public class UsuariosController {
    @Autowired
    private UsuariosService UsuarioService;

    @PostMapping(path="new")
    public ResponseEntity<Usuarios> saveNewUser(@RequestBody Usuarios user){
        Usuarios UserSaved = UsuarioService.Save(user);
        if(UserSaved.getEmail() == null || UserSaved.getPassword() == null || UserSaved.getName() == null){
            return new ResponseEntity<>(UserSaved, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(UserSaved, HttpStatus.CREATED);
    }

    @GetMapping(path = "all")
    public List<Usuarios> getAllUser(){
        return UsuarioService.getAll();
    }
    
    @GetMapping(path = "{id}")
    public Optional<Usuarios> getById(@PathVariable("id") Integer id){
        return UsuarioService.getById(id);
    }
    
    @GetMapping(path = "emailexist/{email}")
    public boolean getByEmail(@PathVariable("email") String email){
        return UsuarioService.EmailExist(email);
    }
    
    @GetMapping(path = "{email}/{password}")
    public Usuarios getExistencia(@PathVariable("email") String email, @PathVariable("password") String password){
        Usuarios users = UsuarioService.ExisteUsuario(email, password);
        return users;
    }
    
    @PutMapping(path="update")
    public ResponseEntity<Usuarios> UpdateUser(@RequestBody Usuarios user){
        Usuarios userU = UsuarioService.update(user);
        if(userU.getEmail() == null || userU.getPassword() == null || userU.getName() == null){
            return new ResponseEntity<>(userU, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userU, HttpStatus.CREATED);
    }
    
    @DeleteMapping(path="{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Integer id){
        UsuarioService.Delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
