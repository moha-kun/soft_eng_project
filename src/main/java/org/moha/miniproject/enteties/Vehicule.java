package org.moha.miniproject.enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
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

    @OneToMany(mappedBy = "vehicule")
    @JsonIgnore
    private List<Voyage> voyages;

    @OneToMany(mappedBy = "vehicule",
            cascade = CascadeType.ALL)
    private List<CarteGrise> carteGrises;

    @OneToMany(mappedBy = "vehicule",
            cascade = CascadeType.ALL)
    private List<Assurance> assurances;

    @OneToMany(mappedBy = "vehicule",
            cascade = CascadeType.ALL)
    private List<VisiteTechnique> visiteTechniques;

    @OneToMany( mappedBy = "vehicule",
            cascade = CascadeType.ALL)
    private List<Vignette> vignettes;
}
