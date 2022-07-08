/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.ejercicio1.controller;

import com.spring.ejercicio1.Dao.PersonajeDao;
import com.spring.ejercicio1.services.Services;
import com.spring.ejercicio1.character.Personajes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class controlador {

    @Autowired
    private Services services;
    RestTemplate restTemplate;

    private PersonajeDao personajeDao;

    @GetMapping("/tudominio.com/api/character")
    public List<Personajes> listaPersonajes() {
        return services.listaPersonajes();
    }

    
    @PostMapping("tudominio.com/api/character/guardar")
    public void guardar(@RequestBody Personajes personajes) {
        this.services.guardar(personajes); 
    }

    @GetMapping(value = "/prueba")
    public String getPersonasjes( ) {
        String url = "https://rickandmortyapi.com/api/character";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    
    @GetMapping(path = "/tudominio.com/api/character/{id}")
    public Personajes buscar(@PathVariable("id") Personajes personajes ) {
        return this.services.buscar(personajes);
    }

    @DeleteMapping(path = "tudominio.com/api/character/{id}")
    public void eliminar(@PathVariable("id") Personajes personajes ) {
        this.services.eliminar(personajes);
    }

    @GetMapping(value = "rickandmortyapi.com/api/character")
    public List<Personajes> getPersonajes() {
        String url = "https://rickandmortyapi.com/api/character";
        RestTemplate restTemplate = new RestTemplate();

        Personajes[] personajes = restTemplate.getForObject(url, Personajes[].class);

        return Arrays.asList(personajes);
    }
    
    @GetMapping("tudominio.com/api/charactere")
    public List<Personajes> buscar(@RequestParam (required=false)String status){
        if (status==null){
            return services.listaPersonajes();
        }
        
        List<Personajes> buscarStatus= new ArrayList<>();
        
        Personajes personajes = services.getPersonajesByStatus(status);
        buscarStatus.add(personajes); 
        
        return buscarStatus;
    }
     
    
    
    
  /* Intento de almacenar datos en la BBDD 
    @RequestMapping(value = "/guardar4", method = RequestMethod.POST)
   public Personajes createProducts(@RequestBody Personajes newPersonajes) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<Personajes> entity = new HttpEntity<Personajes>(newPersonajes,headers);
      
      return restTemplate.exchange(
         "https://rickandmortyapi.com/api/character", HttpMethod.POST, entity, Personajes.class).getBody();
   }    */
    
    
    /* Intento 2 de almacenar datos 
    @PostMapping(value = "/guardar", consumes = "application/json", produces = "application/json")
    
    public String NewPersonajes(@RequestBody Personajes personajes) {
        String url = "https://rickandmortyapi.com/api/character";
        RestTemplate restTemplate = new RestTemplate();
      String result = restTemplate.getForObject(url, String.class);
      Personajes crearPersonajes= new Personajes();

        crearPersonajes = restTemplate.postForObject(result.getBytes("id"), personajes, Personajes.class);
        this.services.guardar(personajes);
        return this.NewPersonajes(personajes);
   } */
    
    /* Intento 3 de almacenar datos

    @PostMapping(value = "/createPerson", consumes = "application/json", produces = "application/json")
    public void createPerson(@RequestBody Personajes personajes) {
         this.services.guardar(personajes);
    } */
    
    
    
    
    

    

}
