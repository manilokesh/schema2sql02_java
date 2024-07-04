package com.lv.hims.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.lv.hims.beans.dto.InventoryItemDto;
import com.lv.hims.entity.InventoryItem;
import com.lv.hims.repository.InventoryItemRepository;
import com.lv.hims.service.InventoryItemService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryItemServiceImpl implements InventoryItemService {

    private final InventoryItemRepository inventoryItemRepository;
    private final ModelMapper modelMapper;

    @Override
    public InventoryItemDto createInventoryItem(InventoryItemDto InventoryItemDto) {
        InventoryItem inventoryItem = modelMapper.map(InventoryItemDto, InventoryItem.class);
        InventoryItem savedInventoryItem = inventoryItemRepository.save(inventoryItem);
        return modelMapper.map(savedInventoryItem, InventoryItemDto.class);
    }

    @Override
    public InventoryItemDto updateInventoryItem(Long itemId, InventoryItemDto InventoryItemDto) {
        InventoryItem existingInventoryItem = inventoryItemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Inventory Item not found"));
        modelMapper.map(InventoryItemDto, existingInventoryItem);
        InventoryItem updatedInventoryItem = inventoryItemRepository.save(existingInventoryItem);
        return modelMapper.map(updatedInventoryItem, InventoryItemDto.class);
    }

    @Override
    public void deleteInventoryItem(Long itemId) {
        inventoryItemRepository.deleteById(itemId);
    }

    @Override
    public InventoryItemDto getInventoryItemById(Long itemId) {
        InventoryItem inventoryItem = inventoryItemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Inventory Item not found"));
        return modelMapper.map(inventoryItem, InventoryItemDto.class);
    }

    @Override
    public List<InventoryItemDto> getAllInventoryItems() {
        return inventoryItemRepository.findAll().stream()
                .map(inventoryItem -> modelMapper.map(inventoryItem, InventoryItemDto.class))
                .collect(Collectors.toList());
    }
}
