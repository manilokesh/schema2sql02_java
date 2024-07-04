package com.lv.hims.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.lv.hims.beans.dto.PatientDto;
import com.lv.hims.entity.Patient;
import com.lv.hims.repository.PatientRepository;
import com.lv.hims.service.PatientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Override
    public PatientDto createPatient(PatientDto PatientDto) {
        Patient patient = modelMapper.map(PatientDto, Patient.class);
        Patient savedPatient = patientRepository.save(patient);
        return modelMapper.map(savedPatient, PatientDto.class);
    }

    @Override
    public PatientDto updatePatient(Long patientId, PatientDto PatientDto) {
        Patient existingPatient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
        modelMapper.map(PatientDto, existingPatient);
        Patient updatedPatient = patientRepository.save(existingPatient);
        return modelMapper.map(updatedPatient, PatientDto.class);
    }

    @Override
    public void deletePatient(Long patientId) {
        patientRepository.deleteById(patientId);
    }

    @Override
    public PatientDto getPatientById(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
        return modelMapper.map(patient, PatientDto.class);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(patient -> modelMapper.map(patient, PatientDto.class))
                .collect(Collectors.toList());
    }
}
