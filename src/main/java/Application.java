import dao.EventoDAO;
import entities.Evento;
import enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventiPU");
        EntityManager em = emf.createEntityManager();

        EventoDAO dao = new EventoDAO(em);

        Evento evento = new Evento(
                "Concerto",
                LocalDate.now(),
                "Concerto rock",
                TipoEvento.PUBBLICO,
                1000
        );

        dao.save(evento);

        Evento eventoTrovato = dao.getById(1);

        System.out.println(eventoTrovato);

        em.close();
        emf.close();
    }
}