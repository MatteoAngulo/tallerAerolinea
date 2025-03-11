package edu.unimagdalena.talleraerolineas.interfaces;

import edu.unimagdalena.talleraerolineas.entities.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryVuelo extends JpaRepository<Vuelo, Long> {
    List<Vuelo> findByOrigen(String origen);

    List<Vuelo> findByDestino(String destino);

    List<Vuelo> findByOrigenAndDestino(String origen, String destino);

    List<Vuelo> findByIdVueloGreaterThan(Long idVuelo);

    List<Vuelo> findByDestinoStartingWith(String prefijo);

    @Query("select v from Vuelo v where v.origen = ?1 and size(v.aerolineas) > 1")
    List<Vuelo> encontrarVuelosPorOrigenConMultiplesAerolineas(String origen);

    @Query("select v from Vuelo v order by length(v.destino) desc limit 1")
    Vuelo encontrarVueloConDestinoMasLargo();

    @Query("select v from Vuelo v where cast(v.numero as string) like %?1%")
    List<Vuelo> encontrarPorNumeroQueContenga(String fragmento);

    @Query("select count(v) from Vuelo v where v.origen = ?1")
    long contarPorOrigen(String origen);

    @Query("select v from Vuelo v order by length(v.origen) desc limit 1")
    Vuelo encontrarVueloConOrigenMasLargo();


}
