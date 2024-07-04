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

import com.lv.hims.beans.dto.BillDto;
import com.lv.hims.service.BillService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @PostMapping
    public ResponseEntity<BillDto> createBill(@Validated @RequestBody BillDto BillDto) {
        BillDto createdBill = billService.createBill(BillDto);
        return ResponseEntity.ok(createdBill);
    }

    @PutMapping("/{billId}")
    public ResponseEntity<BillDto> updateBill(@PathVariable Long billId, @Validated @RequestBody BillDto BillDto) {
        BillDto updatedBill = billService.updateBill(billId, BillDto);
        return ResponseEntity.ok(updatedBill);
    }

    @DeleteMapping("/{billId}")
    public ResponseEntity<Void> deleteBill(@PathVariable Long billId) {
        billService.deleteBill(billId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{billId}")
    public ResponseEntity<BillDto> getBillById(@PathVariable Long billId) {
        BillDto bill = billService.getBillById(billId);
        return ResponseEntity.ok(bill);
    }

    @GetMapping
    public ResponseEntity<List<BillDto>> getAllBills() {
        List<BillDto> bills = billService.getAllBills();
        return ResponseEntity.ok(bills);
    }
}

