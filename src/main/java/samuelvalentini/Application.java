package samuelvalentini;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import samuelvalentini.dao.EventoDAO;
import samuelvalentini.dao.LocationDAO;
import samuelvalentini.dao.PartecipazioneDAO;
import samuelvalentini.dao.PersonaDAO;
import samuelvalentini.entities.Partecipazione;
import samuelvalentini.enumeration.StatoPartecipazione;

import java.util.UUID;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d12ex");


    public static void main(String[] args) {
        EntityManager entityManager = emf.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(entityManager);
//        Location loc1 = new Location("Bar", "Roma");
        LocationDAO locationDAO = new LocationDAO(entityManager);
//        locationDAO.save(loc1);

//        Location loc1ById = locationDAO.getById(UUID.fromString("950bc9db-7b96-4f57-a60c-ad9f2bc891cb"));


//        Evento ev1 = new Evento("Festa grande", LocalDate.of(2026, 3, 25), "la festa dell'anno", TipoEvento.PUBBLICO, 20000, loc1ById);
//        Evento ev2 = new Evento("Festa tonica", LocalDate.of(2026, 6, 25), "la festa più tonica dell'estate", TipoEvento.PRIVATO, 3000, loc1ById);
//        Evento ev3 = new Evento("Festa miscela", LocalDate.of(2026, 11, 25), "miscelati con i migliori", TipoEvento.MISTO, 3000);

//
//
//        eventoDAO.save(ev1);
//        eventoDAO.save(ev2);
//        eventoDAO.save(ev3);
//
//        try {
//            Evento ev1FromDatabase = eventoDAO.getById(UUID.fromString("27ad960c-0c75-4bcc-afe9-7f12c47111d3"));
//            System.out.println(ev1FromDatabase);
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        try {
//            Evento ev1FromDatabase = eventoDAO.getById(UUID.fromString("dd838216-1217-4971-a352-641072a269b6"));
//            System.out.println(ev1FromDatabase);
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        try {
//            eventoDAO.deleteById(UUID.fromString("3f8456f7-0136-4997-ac42-4d6075efe047"));
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }

//      Persona per1 = new Persona("Gino", "Pilotino", "ciao@ciao.it", LocalDate.of(1970, 5, 13), Sesso.M);
        PersonaDAO personaDAO = new PersonaDAO(entityManager);
//      personaDAO.save(per1);


//      Partecipazione par1 = new Partecipazione(personaDAO.getById(UUID.fromString("cad1652a-025e-425b-a1f5-0809a870548b")), eventoDAO.getById(UUID.fromString("dd838216-1217-4971-a352-641072a269b6")), StatoPartecipazione.DA_COMFERMARE);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(entityManager);
//      partecipazioneDAO.save(par1);
        Partecipazione par1DaDatabase = partecipazioneDAO.getById(UUID.fromString("2abfe097-8af8-4fb4-b829-23e052aed458"));
        par1DaDatabase.setStatoPartecipazione(StatoPartecipazione.CONFERMATA);
        partecipazioneDAO.save(par1DaDatabase);
//
        System.out.println(partecipazioneDAO.getById(UUID.fromString("2abfe097-8af8-4fb4-b829-23e052aed458")));

        entityManager.close();
        emf.close();


    }


}
