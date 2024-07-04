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

import com.lv.hims.beans.dto.PatientDto;
import com.lv.hims.service.PatientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@Validated @RequestBody PatientDto PatientDto) {
        PatientDto createdPatient = patientService.createPatient(PatientDto);
        return ResponseEntity.ok(createdPatient);
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable Long patientId, @Validated @RequestBody PatientDto PatientDto) {
        PatientDto updatedPatient = patientService.updatePatient(patientId, PatientDto);
        return ResponseEntity.ok(updatedPatient);
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long patientId) {
        patientService.deletePatient(patientId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long patientId) {
        PatientDto patient = patientService.getPatientById(patientId);
        return ResponseEntity.ok(patient);
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        List<PatientDto> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }
}
