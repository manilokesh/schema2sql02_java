package com.lv.hims.service;

import java.util.List;

import com.lv.hims.beans.dto.PatientDto;

public interface PatientService {
    PatientDto createPatient(PatientDto PatientDto);
    PatientDto updatePatient(Long patientId, PatientDto PatientDto);
    void deletePatient(Long patientId);
    PatientDto getPatientById(Long patientId);
    List<PatientDto> getAllPatients();
}
