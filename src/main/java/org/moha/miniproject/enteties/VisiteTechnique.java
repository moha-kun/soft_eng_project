package org.moha.miniproject.enteties;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "visite_technique")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VisiteTechnique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_visite_technique")
    private Long idVisiteTechnique;

    @Column(name = "date_visite")
    private LocalDate dateVisite;

    @Column(name = "image_scannee")
    private String imageScannee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "vehicule_visite_technique")
    @JoinColumn(name = "id_vehicule")
    private Vehicule vehicule;
}
