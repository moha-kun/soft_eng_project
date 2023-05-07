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
@Table(name = "vignette")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vignette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vignette")
    private Long idVignette;

    @Column(name = "date_soumis")
    private LocalDate dateSoumis;

    @Column(name = "image_scannee")
    private String imageScannee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "vehicule_vignette")
    @JoinColumn(name = "id_vehicule")
    private Vehicule vehicule;
}
