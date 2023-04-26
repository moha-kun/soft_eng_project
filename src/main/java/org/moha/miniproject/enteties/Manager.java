package org.moha.miniproject.enteties;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "manager")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Manager extends User {

    @Column(name = "addresse")
    private String addresse;
}
