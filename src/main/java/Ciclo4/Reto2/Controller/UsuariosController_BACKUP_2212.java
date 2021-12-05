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
/**
*Llamado de clase necesaria
*/
    private UsuariosService UsuarioService;

    @PostMapping(path="new")/**Llamado de clase necesaria*/
    public ResponseEntity<Usuarios> saveNewUser(@RequestBody Usuarios user){
        Usuarios user_saved = UsuarioService.Save(user);
        if(user_saved.getEmail() == null || user_saved.getPassword() == null || user_saved.getName() == null){
            return new ResponseEntity<>(user_saved, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user_saved, HttpStatus.CREATED);
    }

    @GetMapping(path = "all")/**Llamado de clase necesaria*/
    public List<Usuarios> getAllUser(){
        return UsuarioService.getAll();
    }
    
<<<<<<< HEAD
    @GetMapping(path = "{id}")
    public Optional<Usuarios> getById(@PathVariable("id") Integer id){
        return UsuarioService.getById(id);
    }
    
    @GetMapping(path = "emailexist/{email}")
=======
    @GetMapping(path = "emailexist/{email}")/**Llamado de clase necesaria*/
>>>>>>> 722cec9564b40c3d5eba4aaf856bd0d7f5ef1aac
    public boolean getByEmail(@PathVariable("email") String email){
        return UsuarioService.EmailExist(email);
    }
    
    @GetMapping(path = "{email}/{password}")/**Llamado de clase necesaria*/
    public Usuarios getExistencia(@PathVariable("email") String email, @PathVariable("password") String password){
        Usuarios users = UsuarioService.ExisteUsuario(email, password);
        return users;
    }
    
    @PutMapping(path="update")/**Llamado de clase necesaria*/
    public ResponseEntity<Usuarios> update_user(@RequestBody Usuarios user){
        Usuarios userU = UsuarioService.update(user);
        if(userU.getEmail() == null || userU.getPassword() == null || userU.getName() == null){
            return new ResponseEntity<>(userU, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userU, HttpStatus.CREATED);
    }
    
    @DeleteMapping(path="{id}")/**Llamado de clase necesaria*/
    public ResponseEntity deleteUser(@PathVariable("id") Integer ident){
        UsuarioService.Delete(ident);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
