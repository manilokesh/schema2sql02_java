package com.lv.hims.beans.dto;

import java.time.LocalDate;

import com.lv.hims.entity.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PatientDto {
    private Long patientId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private Gender gender;

    private String contactNumber;
    private String email;
    private String address;
    private String medicalHistory;
    private String insuranceNumber;
}
