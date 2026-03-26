package samuelvalentini.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import samuelvalentini.entities.Partecipazione;
import samuelvalentini.exceptions.NotFoundException;
import samuelvalentini.exceptions.NotSavedException;

import java.util.UUID;

public class PartecipazioneDAO {

    private final EntityManager entityManager;

    public PartecipazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void save(Partecipazione newPartecipazione) {
        try {
            EntityTransaction transaction = this.entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(newPartecipazione);
            transaction.commit();
            System.out.println("La Partecipazione a " + newPartecipazione.getEvento() + " per " + newPartecipazione.getPersona() + " è stata generata con successo!");
        } catch (Exception e) {
            throw new NotSavedException(newPartecipazione);
        }

    }

    public Partecipazione getById(UUID idPartecipazione) {
        Partecipazione found = entityManager.find(Partecipazione.class, idPartecipazione);
        if (found == null) throw new NotFoundException(idPartecipazione);
        return found;

    }

    public void deleteById(UUID idPartecipazione) {
        Partecipazione found = this.getById(idPartecipazione);
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("La Partecipazione a " + found.getEvento() + " per " + found.getPersona() + " è stata cancellata dal sistema con successo!");

    }
}
