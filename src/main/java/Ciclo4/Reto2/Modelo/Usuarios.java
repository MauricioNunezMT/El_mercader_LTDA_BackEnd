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
@Document(collection = "usuarios")
/**
 *Clase principal 
 */
public class Usuarios {

@Id    
private Integer id;
/**
 *@param Id
 */
private String identification;
/**
 *@param identificación
 */
private String name;
/**
 *@param nombre
 */
private String address;
/**
 *@param dirección
 */
private String cellPhone;
/**
 *@param Celular
 */
private String email;
/**
 *@param correo
 */
private String password;
/**
 *@param contraseña
 */
private String zone;
/**
 *@param zona
 */
private String type;
/**
 *@param Tipo
 */

}
