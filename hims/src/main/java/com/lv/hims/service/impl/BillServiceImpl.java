package com.lv.hims.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.lv.hims.beans.dto.BillDto;
import com.lv.hims.entity.Bill;
import com.lv.hims.repository.BillRepository;
import com.lv.hims.service.BillService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final ModelMapper modelMapper;

    @Override
    public BillDto createBill(BillDto BillDto) {
        Bill bill = modelMapper.map(BillDto, Bill.class);
        Bill savedBill = billRepository.save(bill);
        return modelMapper.map(savedBill, BillDto.class);
    }

    @Override
    public BillDto updateBill(Long billId, BillDto BillDto) {
        Bill existingBill = billRepository.findById(billId).orElseThrow(() -> new RuntimeException("Bill not found"));
        modelMapper.map(BillDto, existingBill);
        Bill updatedBill = billRepository.save(existingBill);
        return modelMapper.map(updatedBill, BillDto.class);
    }

    @Override
    public void deleteBill(Long billId) {
        billRepository.deleteById(billId);
    }

    @Override
    public BillDto getBillById(Long billId) {
        Bill bill = billRepository.findById(billId).orElseThrow(() -> new RuntimeException("Bill not found"));
        return modelMapper.map(bill, BillDto.class);
    }

    @Override
    public List<BillDto> getAllBills() {
        return billRepository.findAll().stream()
                .map(bill -> modelMapper.map(bill, BillDto.class))
                .collect(Collectors.toList());
    }
}