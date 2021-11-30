/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo4.Reto2.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "gadgets")
/**
 *Clase principal 
 */
public class Gadgets {
    @Id
    private Integer id;
/**
*@param id
*/
    private String brand;
/**
*@param marca
*/
    private String category;
/**
*@param categoría
*/
    private String name;
/**
*@param nombre
*/
    private String description;
/**
*@param descripción
*/
    private double price;
/**
*@param precio
*/
    private boolean availability = true;
/**
*@param existencia
*/
    private int quantity;
/**
*@param cantidad
*/
    private String photography;
/**
*@param fotografía
*/
    
}
