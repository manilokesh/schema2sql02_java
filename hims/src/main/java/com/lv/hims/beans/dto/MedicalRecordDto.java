package com.lv.hims.beans.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MedicalRecordDto {
    private Long recordId;

    @NotNull
    private Long patientId;

    @NotNull
    private Long doctorId;

    @NotNull
    private LocalDate visitDate;

    private String diagnosis;
    private String treatment;
    private String prescriptions;
    private String notes;
}

