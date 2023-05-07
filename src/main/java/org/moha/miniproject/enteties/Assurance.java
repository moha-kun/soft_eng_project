package org.moha.miniproject.enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "assurance")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_assurance")
    private Long idAssurance;

    @Column(name = "date_soumis")
    private LocalDate dateSoumis;

    @Column(name = "duree_mois")
    private int dureeMois;

    @Column(name = "image_scannee")
    private String imageScannee;

    @ManyToOne
    @JoinColumn(name = "id_vehicule")
    @JsonIgnore
    private Vehicule vehicule;
}
