/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Ciclo4.Reto2.Crud;

import Ciclo4.Reto2.Modelo.Usuarios;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author MIGUEL
 */
public interface UsuariosCrudRepository extends MongoRepository<Usuarios, Integer>{
    
    @Query("{id: ?0}")
    public Optional<Usuarios> getById(Integer id);
    
}
