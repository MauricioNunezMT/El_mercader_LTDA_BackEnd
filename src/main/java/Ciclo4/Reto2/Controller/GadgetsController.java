/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo4.Reto2.Controller;

import Ciclo4.Reto2.Modelo.Gadgets;
import Ciclo4.Reto2.Services.GadgetsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gadget")
@CrossOrigin
/**
 *Clase principal
 */
public class GadgetsController {
    @Autowired
    private GadgetsService gadgetsService;
    
    @GetMapping("/all")
    public List<Gadgets> getAll(){
        return gadgetsService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Gadgets> getGadgetsById(@PathVariable("id") Integer id){
    return gadgetsService.getGadgetById(id);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadgets save(@RequestBody Gadgets gadget){
        System.out.println(gadget);
        return gadgetsService.save(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadgets update(@RequestBody Gadgets gadget){
        return gadgetsService.update(gadget);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return gadgetsService.delete(id);
    }

    @GetMapping("description/{description}")
    public List<Gadgets> getByDescription(@PathVariable("description") String description){
        return gadgetsService.findByDesc(description);
    }

    @GetMapping("price/{price}")
    public List<Gadgets> getByPrice(@PathVariable("price") double price){
        return gadgetsService.findByPrice(price);
    }
}
