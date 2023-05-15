package org.moha.miniproject.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class ExceptionMessage {

    private String message;
    private LocalDate date;

}
