package org.moha.miniproject.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vehicule")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicule")
    private Long idVehicule;

    @Column(name = "mtricule")
    private String matricule;

    @Column(name = "type")
    private String model;

    @Column(name = "date_mise_route")
    private LocalDate dateMiseRoute;

    @Column(name = "categorie")
    private Character categorie;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicule")
    private List<Voyage> voyages;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicule")
    private List<CarteGrise> carteGrises;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicule")
    private List<Assurance> assurances;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicule")
    private List<VisiteTechnique> visiteTechniques;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicule")
    private List<Vignette> vignettes;
}
