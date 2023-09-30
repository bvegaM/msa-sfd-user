package com.sfd.msa.user.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ErrorDetail implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String message;
}
