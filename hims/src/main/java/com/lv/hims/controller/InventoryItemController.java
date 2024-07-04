package com.lv.hims.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lv.hims.beans.dto.InventoryItemDto;
import com.lv.hims.service.InventoryItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryItemController {

    private final InventoryItemService inventoryItemService;

    @PostMapping
    public ResponseEntity<InventoryItemDto> createInventoryItem(@Validated @RequestBody InventoryItemDto InventoryItemDto) {
        InventoryItemDto createdInventoryItem = inventoryItemService.createInventoryItem(InventoryItemDto);
        return ResponseEntity.ok(createdInventoryItem);
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<InventoryItemDto> updateInventoryItem(@PathVariable Long itemId, @Validated @RequestBody InventoryItemDto InventoryItemDto) {
        InventoryItemDto updatedInventoryItem = inventoryItemService.updateInventoryItem(itemId, InventoryItemDto);
        return ResponseEntity.ok(updatedInventoryItem);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteInventoryItem(@PathVariable Long itemId) {
        inventoryItemService.deleteInventoryItem(itemId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<InventoryItemDto> getInventoryItemById(@PathVariable Long itemId) {
        InventoryItemDto inventoryItem = inventoryItemService.getInventoryItemById(itemId);
        return ResponseEntity.ok(inventoryItem);
    }

    @GetMapping
    public ResponseEntity<List<InventoryItemDto>> getAllInventoryItems() {
        List<InventoryItemDto> inventoryItems = inventoryItemService.getAllInventoryItems();
        return ResponseEntity.ok(inventoryItems);
    }
}

