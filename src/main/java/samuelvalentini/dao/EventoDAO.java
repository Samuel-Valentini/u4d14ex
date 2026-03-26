package samuelvalentini.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import samuelvalentini.entities.Evento;
import samuelvalentini.exceptions.NotFoundException;
import samuelvalentini.exceptions.NotSavedException;

import java.util.UUID;

public class EventoDAO {
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void save(Evento newEvento) {
        try {
            EntityTransaction transaction = this.entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(newEvento);
            transaction.commit();
            System.out.println("L'evento " + newEvento.getTitolo() + " è stato salvato con successo!");
        } catch (Exception e) {
            throw new NotSavedException(newEvento);
        }

    }

    public Evento getById(UUID idEvento) {
        Evento found = entityManager.find(Evento.class, idEvento);
        if (found == null) throw new NotFoundException(idEvento);
        return found;

    }

    public void deleteById(UUID idEvento) {
        Evento found = this.getById(idEvento);
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("L'evento " + found.getTitolo() + " è stato eliminato con successo!");

    }
}
