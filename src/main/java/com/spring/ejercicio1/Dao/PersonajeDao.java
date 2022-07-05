/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.ejercicio1.Dao;

import com.spring.ejercicio1.character.Personajes;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PersonajeDao  extends CrudRepository<Personajes, Long>{

}
