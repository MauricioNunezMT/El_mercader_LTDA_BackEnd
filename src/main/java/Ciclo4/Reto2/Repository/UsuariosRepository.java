/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo4.Reto2.Repository;

import Ciclo4.Reto2.Crud.UsuariosCrudRepository;
import Ciclo4.Reto2.Modelo.Usuarios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
/**
 *Clase principal
 */
public class UsuariosRepository {
    @Autowired
    private UsuariosCrudRepository repo;
    
    public List<Usuarios> getAll(){
        return repo.findAll();
    }
    
     public Optional<Usuarios> getById(Integer id){
        return repo.getById(id);
    }
    
    public Usuarios save(Usuarios usuario){
        return repo.save(usuario);
    }
    
    public void delete(Usuarios usuario){
        repo.delete(usuario);
    }
}
