package com.lv.hims.beans.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DoctorDto {
    private Long doctorId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String specialty;
    private String contactNumber;
    private String email;
}
