package com.lv.hims.service;

import java.util.List;

import com.lv.hims.beans.dto.InventoryItemDto;

public interface InventoryItemService {
    InventoryItemDto createInventoryItem(InventoryItemDto InventoryItemDto);
    InventoryItemDto updateInventoryItem(Long itemId, InventoryItemDto InventoryItemDto);
    void deleteInventoryItem(Long itemId);
    InventoryItemDto getInventoryItemById(Long itemId);
    List<InventoryItemDto> getAllInventoryItems();
}