/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo4.Reto2.Repository;

import Ciclo4.Reto2.Crud.GadgetsCrudRepository;
import Ciclo4.Reto2.Modelo.Gadgets;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
/**
 *Clase principal
 */
public class GadgetsRepository {
    @Autowired
    private GadgetsCrudRepository repository;
    
    public List<Gadgets> getAll(){
        return repository.findAll();
    }
    
    public Optional<Gadgets> getGadgetById(int id){
        return repository.findById(id);
    }
    
    public Gadgets save(Gadgets gadget){
        return repository.save(gadget);
    }
    
    public void update(Gadgets gadget){
        repository.save(gadget);
    }
    
    public void delete(Gadgets gadget){
        repository.delete(gadget);
    }
}
