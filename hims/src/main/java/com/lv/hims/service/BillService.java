package com.lv.hims.service;

import java.util.List;

import com.lv.hims.beans.dto.BillDto;

public interface BillService {
    BillDto createBill(BillDto BillDto);
    BillDto updateBill(Long billId, BillDto BillDto);
    void deleteBill(Long billId);
    BillDto getBillById(Long billId);
    List<BillDto> getAllBills();
}
