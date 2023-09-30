package com.sfd.msa.user.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Error implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String title;

    private String detail;

    private List<ErrorDetail> errors;

    private Integer status;
}
