package dao;

import entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {

    private EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public Evento getById(long id) {
        return entityManager.find(Evento.class, id);
    }

    public void save(Evento evento) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(evento);

        transaction.commit();

        System.out.println("Evento salvato!");
    }
    public void delete(long id) {
        Evento evento = getById(id);

        if (evento != null) {
            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.remove(evento);
            transaction.commit();

            System.out.println("Evento eliminato!");
        } else {
            System.out.println("Evento non trovato!");
        }
    }
}
