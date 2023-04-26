package org.moha.miniproject.enteties;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "conducteur")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Conducteur extends User {

    @Column(name = "matricule")
    private String matricule;

    @Column(name = "cin")
    private String cin;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "conducteur")
    private List<Permis> permis;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "conducteur")
    private List<Voyage> voyages;

}
