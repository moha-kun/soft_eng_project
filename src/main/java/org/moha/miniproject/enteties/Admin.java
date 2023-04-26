package org.moha.miniproject.enteties;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "admin")
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Admin extends User {
}
