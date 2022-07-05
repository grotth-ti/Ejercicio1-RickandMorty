/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.ejercicio1.controller;

import com.spring.ejercicio1.Dao.PersonajeDao;
import com.spring.ejercicio1.services.Services;
import com.spring.ejercicio1.character.Personajes;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class controlador {

    @Autowired
    private Services services;

    private PersonajeDao personajeDao;
    
    @GetMapping("/tudominio.com/api/character")
    public List<Personajes> listaPersonajes() {
        return services.listaPersonajes();
    }
    
   @PostMapping("/tudominio.com/api/character/guardar")
    public void guardar (@RequestBody Personajes personajes){
        this.services.guardar(personajes);
    }
    
    @GetMapping(path="/tudominio.com/api/character/{id}")
    public Personajes buscar(@PathVariable("id")Personajes personajes){
     return this.services.buscar(personajes);
    }
    
    @DeleteMapping(path= "tudominio.com/api/character/{id}")
    public void eliminar(@PathVariable("id") Personajes personajes){
       this.services.eliminar(personajes);
    }
    
    
    
    
    @GetMapping (value="rickandmortyapi.com/api/character")
            public List<Personajes> getPersonajes(){
                String url="https://rickandmortyapi.com/api/character";
                RestTemplate restTemplate = new RestTemplate();
                
                Personajes[] personajes= restTemplate.getForObject(url, Personajes[].class);
                
                return Arrays.asList(personajes);
            }
    
    
   
    
}
