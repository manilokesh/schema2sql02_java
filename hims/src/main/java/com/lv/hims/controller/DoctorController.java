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

import com.lv.hims.beans.dto.DoctorDto;
import com.lv.hims.service.DoctorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@Validated @RequestBody DoctorDto DoctorDto) {
        DoctorDto createdDoctor = doctorService.createDoctor(DoctorDto);
        return ResponseEntity.ok(createdDoctor);
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable Long doctorId, @Validated @RequestBody DoctorDto DoctorDto) {
        DoctorDto updatedDoctor = doctorService.updateDoctor(doctorId, DoctorDto);
        return ResponseEntity.ok(updatedDoctor);
    }

    @DeleteMapping("/{doctorId}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long doctorId) {
        doctorService.deleteDoctor(doctorId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long doctorId) {
        DoctorDto doctor = doctorService.getDoctorById(doctorId);
        return ResponseEntity.ok(doctor);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        List<DoctorDto> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }
}

