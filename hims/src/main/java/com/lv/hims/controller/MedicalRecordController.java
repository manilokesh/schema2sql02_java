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

import com.lv.hims.beans.dto.MedicalRecordDto;
import com.lv.hims.service.MedicalRecordService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/medical-records")
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @PostMapping
    public ResponseEntity<MedicalRecordDto> createMedicalRecord(@Validated @RequestBody MedicalRecordDto MedicalRecordDto) {
        MedicalRecordDto createdMedicalRecord = medicalRecordService.createMedicalRecord(MedicalRecordDto);
        return ResponseEntity.ok(createdMedicalRecord);
    }

    @PutMapping("/{recordId}")
    public ResponseEntity<MedicalRecordDto> updateMedicalRecord(@PathVariable Long recordId, @Validated @RequestBody MedicalRecordDto MedicalRecordDto) {
        MedicalRecordDto updatedMedicalRecord = medicalRecordService.updateMedicalRecord(recordId, MedicalRecordDto);
        return ResponseEntity.ok(updatedMedicalRecord);
    }

    @DeleteMapping("/{recordId}")
    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable Long recordId) {
        medicalRecordService.deleteMedicalRecord(recordId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{recordId}")
    public ResponseEntity<MedicalRecordDto> getMedicalRecordById(@PathVariable Long recordId) {
        MedicalRecordDto medicalRecord = medicalRecordService.getMedicalRecordById(recordId);
        return ResponseEntity.ok(medicalRecord);
    }

    @GetMapping
    public ResponseEntity<List<MedicalRecordDto>> getAllMedicalRecords() {
        List<MedicalRecordDto> medicalRecords = medicalRecordService.getAllMedicalRecords();
        return ResponseEntity.ok(medicalRecords);
    }
}

