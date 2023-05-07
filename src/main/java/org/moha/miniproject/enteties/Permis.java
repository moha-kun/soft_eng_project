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
@Table(name = "permis")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Permis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permis")
    private Long idPermis;

    @Column(name = "date_remise")
    private LocalDate dateRemis;

    @Column(name = "type")
    private Character type;

    @Column(name = "image_scannee")
    private String imageScannee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conducteur")
    @JsonBackReference(value = "conducteur-permis")
    private Conducteur conducteur;
}
