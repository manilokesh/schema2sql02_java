package com.lv.hims.beans.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InventoryItemDto {
    private Long itemId;

    @NotBlank
    private String itemName;

    @NotNull
    private Integer quantity;

    private String supplier;
    private LocalDate expirationDate;
}
