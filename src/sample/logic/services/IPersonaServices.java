package sample.logic.services;

import sample.logic.entities.Persona;

import java.util.List;
import java.util.UUID;

public interface IPersonaServices {

    List<Persona> getAll();

    Persona getById(UUID id);

    Persona insert(Persona persona);

    void delete(List<Persona> personas);

    void export() throws Exception;


}