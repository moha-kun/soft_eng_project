package org.moha.miniproject.enteties;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference(value = "conducteur_permis")
    private List<Permis> permis;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "conducteur")
    @JsonManagedReference(value = "conducteur_voyage")
    private List<Voyage> voyages;

}
