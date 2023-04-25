package org.moha.miniproject.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "voyage")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voyage")
    private Long idVoyage;

    @Column(name = "point_depart")
    private String pointDepart;

    @Column(name = "point_arrivee")
    private String pointArrivee;

    @Column(name = "date_depart")
    private LocalDate dateDepart;

    @Column(name = "date_arrivee")
    private LocalDate dateArrivee;

    @Column(name = "type_vehicule")
    private Character typeVehicule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conducteur")
    private Conducteur conducteur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehicule")
    private Vehicule vehicule;
}
