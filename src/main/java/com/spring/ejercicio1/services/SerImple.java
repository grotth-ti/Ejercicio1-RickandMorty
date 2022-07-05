/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.ejercicio1.services;

import com.spring.ejercicio1.Dao.PersonajeDao;
import com.spring.ejercicio1.character.Personajes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SerImple implements Services {

    @Autowired
    PersonajeDao personajeDao;

    @Override
    @Transactional(readOnly = true)
    public List<Personajes> listaPersonajes() {
        return (List<Personajes>) personajeDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Personajes personajes) {
        personajeDao.save(personajes);
    }

    @Override
    @Transactional
    public void eliminar(Personajes personajes) {
        personajeDao.delete(personajes);
    }

    @Override
    @Transactional(readOnly = true)
    public Personajes buscar(Personajes personajes) {
        return personajeDao.findById(personajes.getId()).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Personajes> getPersonajes() {
        return (List<Personajes>) personajeDao.findAll();
    }
}
