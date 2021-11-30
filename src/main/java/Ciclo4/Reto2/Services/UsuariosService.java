/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo4.Reto2.Services;

import Ciclo4.Reto2.Modelo.Usuarios;
import Ciclo4.Reto2.Repository.UsuariosRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 *clase principal
 */
public class UsuariosService {
    @Autowired
    private UsuariosRepository repo;
    
    public List<Usuarios> getAll(){
        return repo.getAll();
    }
    
    public Usuarios Save(Usuarios user){
        return repo.save(user);
    }
    
    public void Delete(Integer id){
        Optional <Usuarios> us = repo.getById(id);
         if (us.isPresent()) {
            repo.delete(us.get());
        }
    }
    
    public Usuarios update(Usuarios user) {
        Optional<Usuarios> us = repo.getById(user.getId());
        if (us.isPresent()) {
            us.get().setId(user.getId());
            us.get().setEmail(user.getEmail());
            us.get().setAddress(user.getAddress());
            us.get().setCellPhone(user.getCellPhone());
            us.get().setIdentification(user.getIdentification());
            us.get().setPassword(user.getPassword());
            us.get().setName(user.getName());
            us.get().setZone(user.getZone());
            us.get().setType(user.getType());
            
            return repo.save(us.get());
        }
        return user;
    }
    
    public boolean EmailExist(String email){
        List<Usuarios> users = repo.getAll();
        ArrayList<String> valida = new ArrayList<>();
        boolean respuesta = false;
        users.forEach(
                    user ->{
                        if(user.getEmail().equals(email)){
                            valida.add(email);
                        }
                    }
            );
            if (valida.isEmpty()){
                respuesta = false;
            }else{
                respuesta = true;
            }
            return respuesta;
    }
    
    public Usuarios ExisteUsuario(String email, String password){
        List<Usuarios> users = repo.getAll();
        Usuarios usersToSend = new Usuarios();
        users.forEach(
                user ->{
                    if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                        usersToSend.setId(user.getId());
                        usersToSend.setIdentification(user.getIdentification());
                        usersToSend.setName(user.getName());
                        usersToSend.setAddress(user.getAddress());
                        usersToSend.setCellPhone(user.getCellPhone());
                        usersToSend.setEmail(user.getEmail());
                        usersToSend.setPassword(user.getPassword());
                        usersToSend.setZone(user.getZone());
                        usersToSend.setType(user.getType());
                    }else{
                        usersToSend.setName("NO DEFINIDO");
                        usersToSend.setEmail(email);
                        usersToSend.setPassword(password);
                    }
                }
        );
        return usersToSend;
    }
    
}
