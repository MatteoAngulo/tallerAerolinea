package edu.unimagdalena.talleraerolineas.entities;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pasaportes")
public class Pasaporte {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPasaporte;

    @Column(nullable = false)
    private String numero;

    @OneToOne(optional = false) @JoinColumn(name = "id_pasajero",referencedColumnName = "idPasajero")
    private Pasajero pasajero;

}
