package com.lv.hims.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.lv.hims.beans.dto.MedicalRecordDto;
import com.lv.hims.entity.MedicalRecord;
import com.lv.hims.repository.MedicalRecordRepository;
import com.lv.hims.service.MedicalRecordService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;
    private final ModelMapper modelMapper;

    @Override
    public MedicalRecordDto createMedicalRecord(MedicalRecordDto MedicalRecordDto) {
        MedicalRecord medicalRecord = modelMapper.map(MedicalRecordDto, MedicalRecord.class);
        MedicalRecord savedMedicalRecord = medicalRecordRepository.save(medicalRecord);
        return modelMapper.map(savedMedicalRecord, MedicalRecordDto.class);
    }

    @Override
    public MedicalRecordDto updateMedicalRecord(Long recordId, MedicalRecordDto MedicalRecordDto) {
        MedicalRecord existingMedicalRecord = medicalRecordRepository.findById(recordId).orElseThrow(() -> new RuntimeException("Medical Record not found"));
        modelMapper.map(MedicalRecordDto, existingMedicalRecord);
        MedicalRecord updatedMedicalRecord = medicalRecordRepository.save(existingMedicalRecord);
        return modelMapper.map(updatedMedicalRecord, MedicalRecordDto.class);
    }

    @Override
    public void deleteMedicalRecord(Long recordId) {
        medicalRecordRepository.deleteById(recordId);
    }

    @Override
    public MedicalRecordDto getMedicalRecordById(Long recordId) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(recordId).orElseThrow(() -> new RuntimeException("Medical Record not found"));
        return modelMapper.map(medicalRecord, MedicalRecordDto.class);
    }

    @Override
    public List<MedicalRecordDto> getAllMedicalRecords() {
        return medicalRecordRepository.findAll().stream()
                .map(medicalRecord -> modelMapper.map(medicalRecord, MedicalRecordDto.class))
                .collect(Collectors.toList());
    }
}
