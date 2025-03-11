package edu.unimagdalena.talleraerolineas.interfaces;

import edu.unimagdalena.talleraerolineas.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface RepositoryReserva extends JpaRepository<Reserva, Long> {


    Reserva findByIdReserva(Long idReserva);
    Reserva findByCodigoReserva(UUID codigo);
    List<Reserva> findByIdReservaAfter(Long numero);
    List<Reserva> findByCodigoReservaIn(Collection<UUID> codigoReservas);
    Reserva findByIdPasajero(Long idPasajero);

    @Query("select r from Reserva as r where r.idReserva between ?1 and ?2")
    List<Reserva> findByReservaBetween(Long min, Long max);

    @Query("select r from Reserva as r where CAST(r.codigoReserva AS string) > '00000000-0000-0000-0000-000000000001' ")
    List<Reserva> buscarReservaCodigoReservaMayorUno();

    @Query("select r from Reserva as r where r.codigoReserva in(?1, ?2, ?3)")
    List<Reserva> buscarReservaCodigoConjunto(Long numero1, Long numero2, Long numero3);

    @Query("select r from Reserva as r where r.vuelo.idVuelo = ?1")
    Reserva buscarReservaPorIdVuelo(Long idVuelo);

    @Query("select r from Reserva as r where r.pasajero.idPasajero = ?1")
    Reserva buscarReservaPorIdPasajero(Long idPasajero);
}
