/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo4.Reto2.Modelo;

import java.util.Date;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
/**
*Clase principal 
*/
public class Order {
    public static String PENDING = "Pendiente";
    public static String APROVED = "Aprobada";
    public static String REJECTED = "Rechazada";

    @Id

    private Integer id;
    /**@param Id*/
    private Date registerDay;
    /**@param registro*/
    private String status;
    /**@param estado*/
    private Usuarios salesMan;
    /**@param comprador*/
    private Map<Integer, Gadgets> products;
    /**@param Gadgets*/
    private Map<Integer, Integer> quantities;   
    /**@param cantidad*/
}
