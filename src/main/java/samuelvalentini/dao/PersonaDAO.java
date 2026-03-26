package samuelvalentini.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import samuelvalentini.entities.Persona;
import samuelvalentini.exceptions.NotFoundException;
import samuelvalentini.exceptions.NotSavedException;

import java.util.UUID;

public class PersonaDAO {

    private final EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void save(Persona newPersona) {
        try {
            EntityTransaction transaction = this.entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(newPersona);
            transaction.commit();
            System.out.println(newPersona.getNome() + newPersona.getCognome() + " è stata registrata con successo!");
        } catch (Exception e) {
            throw new NotSavedException(newPersona);
        }

    }

    public Persona getById(UUID idPersona) {
        Persona found = entityManager.find(Persona.class, idPersona);
        if (found == null) throw new NotFoundException(idPersona);
        return found;

    }

    public void deleteById(UUID idPersona) {
        Persona found = this.getById(idPersona);
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println(found.getNome() + found.getCognome() + " è stata cancellata dal sistema con successo!");

    }
}
