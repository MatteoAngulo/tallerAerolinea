package edu.unimagdalena.talleraerolineas.entities;

import lombok.*;
import jakarta.persistence.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pasajeros")
public class Pasajero {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPasajero;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String nid;

    @OneToOne(mappedBy = "pasajero")
    private Pasaporte pasaporte;

    @OneToMany(mappedBy = "pasajero")
    private Set<Reserva> reservas;
}
