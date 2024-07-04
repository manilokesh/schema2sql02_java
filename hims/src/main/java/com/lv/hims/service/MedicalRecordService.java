package com.lv.hims.service;

import java.util.List;

import com.lv.hims.beans.dto.MedicalRecordDto;

public interface MedicalRecordService {
    MedicalRecordDto createMedicalRecord(MedicalRecordDto MedicalRecordDto);
    MedicalRecordDto updateMedicalRecord(Long recordId, MedicalRecordDto MedicalRecordDto);
    void deleteMedicalRecord(Long recordId);
    MedicalRecordDto getMedicalRecordById(Long recordId);
    List<MedicalRecordDto> getAllMedicalRecords();
}
