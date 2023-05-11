package org.moha.miniproject.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PasswordUpdateDTO {
    private String oldPassword;
    private String newPassword;
}
