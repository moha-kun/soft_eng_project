package org.moha.miniproject.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "conducteur")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Conducteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conducteur")
    private Long idConducteur;

    @Column(name = "matricule")
    private String matricule;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "cin")
    private String cin;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "conducteur")
    private List<Permis> permis;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "conducteur")
    private List<Voyage> voyages;

}
