/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo4.Reto2.Repository;

import Ciclo4.Reto2.Crud.OrdersCrudRepository;
import Ciclo4.Reto2.Modelo.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
/**
 *Clase principal
 */
public class OrderRepository {
    @Autowired
    private OrdersCrudRepository repository;
    
    public List<Order> getAll(){
        return repository.findAll();
    }
    
    public Optional<Order> getById(int id){
        return repository.findById(id);
    }
    
    public Order save(Order orden){
        return repository.save(orden);
    }
    
    public void update(Order orden){
        repository.save(orden);
    }
    
    public void delete(Order orden){
        repository.delete(orden);
    }

}
