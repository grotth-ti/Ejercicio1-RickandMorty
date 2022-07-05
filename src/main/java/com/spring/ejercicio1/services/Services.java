/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.ejercicio1.services;

import com.spring.ejercicio1.character.Personajes;
import java.util.List;

public interface Services {

    public List<Personajes> listaPersonajes();

    public void guardar(Personajes personajes);

    public void eliminar(Personajes personajes);

    public Personajes buscar(Personajes personajes);
    
        public List<Personajes> getPersonajes();

}
