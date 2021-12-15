/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo4.Reto2.Services;

import Ciclo4.Reto2.Modelo.Order;
import Ciclo4.Reto2.Modelo.Usuarios;
import Ciclo4.Reto2.Repository.OrderRepository;
import Ciclo4.Reto2.Repository.UsuariosRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
/**
 *clase principal
 */
public class OrderService {
    @Autowired
    private OrderRepository repo;

    @Autowired
    private UsuariosRepository repoU;

    public List<Order> getAll(){
        return repo.getAll();
    }

    public Order Save(Order orden){
        return repo.save(orden);
    }

    public Optional<Order> getOrderById(int id){
        return repo.getById(id);
    }

    public void Delete(Integer id){
        Optional <Order> us = repo.getById(id);
         if (us.isPresent()) {
            repo.delete(us.get());
        }
    }

    public Order update(Order orden) {
        Optional<Order> or = repo.getById(orden.getId());
        if (or.isPresent()) {
            if(orden.getStatus() == "Rechazada" || orden.getStatus()=="Aprobada"){
                or.get().setId(orden.getId());
                or.get().setStatus(orden.getStatus());

                return repo.save(or.get());
            }
        }
        return orden;
    }

    public List<Order> getAllByZone(String zona){
        List<Usuarios> users = repoU.getAll();
        List<Order> orden = repo.getAll();
        List<Order> existencia = new ArrayList<>();
        users.forEach(
                    user ->{
                        if(user.getZone().equals(zona)){
                            orden.forEach(
                                ord ->{
                                    if(ord.getSalesMan().equals(user)){
                                        existencia.add(ord);
                                    }
                                }
                            );
                        }
                    }
            );
        return existencia;
    }

    public List<Order> getBySaleMan(Integer id){
        List<Order> orders = repo.getAll();
        List<Usuarios> users = repoU.getAll();
        List<Order> saleManOrder = new ArrayList<>();

        users.forEach(
                user ->{
                    if(user.getId().equals(id)){
                        orders.forEach(
                                ord ->{
                                    if(ord.getSalesMan().equals(user)){
                                        saleManOrder.add(ord);
                                    }
                                }
                        );
                    }
                }
        );
        return saleManOrder;
    }

    public List<Order> getByDate(String date, Integer id){
        List<Order> orders = repo.getAll();
        List<Usuarios> users = repoU.getAll();
        List<Order> ordersByDate = new ArrayList<>();

        orders.forEach(
                registerDate ->{
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date Rdate = registerDate.getRegisterDay();
                    if(sdf.format(Rdate).equals(date)){
                        users.forEach(
                                user ->{
                                    if(user.getId().equals(id)){
                                        orders.forEach(
                                                ord ->{
                                                    if(ord.getSalesMan().equals(user)){
                                                        ordersByDate.add(ord);
                                                    }
                                                }
                                        );
                                    }
                                }
                        );
                    }
                }
        );
        return ordersByDate;
    }

    public List<Order> getByStatus(String  status, Integer id){
        List<Order> statusO = repo.getAll();
        List<Usuarios> users = repoU.getAll();
        List<Order> ordersByStatus = new ArrayList<>();

        statusO.forEach(
                registerDate ->{
                    if(registerDate.getStatus().equals(status)){
                        users.forEach(
                                user ->{
                                    if(user.getId().equals(id)){
                                        statusO.forEach(
                                                ord ->{
                                                    if(ord.getSalesMan().equals(user)){
                                                        ordersByStatus.add(ord);
                                                    }
                                                }
                                        );
                                    }
                                }
                        );
                    }
                }
        );
        return ordersByStatus;
    }
    
}
