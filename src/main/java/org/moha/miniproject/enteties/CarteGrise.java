package org.moha.miniproject.enteties;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "carte_grise")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarteGrise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carte_grise")
    private Long idCarteGrise;

    @Column(name = "date_soumis")
    private LocalDate dateSoumis;

    @Column(name = "matricule")
    private String matricule;

    @Column(name = "num_chasis")
    private String numChasis;

    @Column(name = "image_scannee")
    private String imageScannee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "vehicle-carte_grise")
    @JoinColumn(name = "id_vehicule")
    private Vehicule vehicule;
}
