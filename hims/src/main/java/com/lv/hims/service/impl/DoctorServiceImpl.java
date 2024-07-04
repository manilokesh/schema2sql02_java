package com.lv.hims.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.lv.hims.beans.dto.DoctorDto;
import com.lv.hims.entity.Doctor;
import com.lv.hims.repository.DoctorRepository;
import com.lv.hims.service.DoctorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    @Override
    public DoctorDto createDoctor(DoctorDto DoctorDto) {
        Doctor doctor = modelMapper.map(DoctorDto, Doctor.class);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return modelMapper.map(savedDoctor, DoctorDto.class);
    }

    @Override
    public DoctorDto updateDoctor(Long doctorId, DoctorDto DoctorDto) {
        Doctor existingDoctor = doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));
        modelMapper.map(DoctorDto, existingDoctor);
        Doctor updatedDoctor = doctorRepository.save(existingDoctor);
        return modelMapper.map(updatedDoctor, DoctorDto.class);
    }

    @Override
    public void deleteDoctor(Long doctorId) {
        doctorRepository.deleteById(doctorId);
    }

    @Override
    public DoctorDto getDoctorById(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));
        return modelMapper.map(doctor, DoctorDto.class);
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDto.class))
                .collect(Collectors.toList());
    }
}
