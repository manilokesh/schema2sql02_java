package com.lv.hims.beans.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BillDto {
    private Long billId;

    @NotNull
    private Long patientId;

    @NotNull
    private Double amount;

    @NotBlank
    private String paymentStatus;

    @NotNull
    private LocalDateTime billingDate;
}

