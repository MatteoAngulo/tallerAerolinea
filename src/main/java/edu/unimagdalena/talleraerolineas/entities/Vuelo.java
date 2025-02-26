package edu.unimagdalena.talleraerolineas.entities;

import lombok.*;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vuelos")

public class Vuelo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVuelo;
    @Column(nullable = false)
    private UUID numero;
    @Column(nullable = false)
    private String origen;
    @Column(nullable = false)
    private String destino;

    @ManyToMany(mappedBy = "vuelos")
    private Set<Aerolinea> aerolineas;

    @OneToMany(mappedBy = "vuelo")
    private Set<Reserva> reservas;

//    @JoinColumn(name = "id_aerolinea")
//    private Aerolinea aerolinea;

}
