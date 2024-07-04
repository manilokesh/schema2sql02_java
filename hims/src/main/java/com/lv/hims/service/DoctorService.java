package com.lv.hims.service;

import java.util.List;

import com.lv.hims.beans.dto.DoctorDto;

public interface DoctorService {
    DoctorDto createDoctor(DoctorDto DoctorDto);
    DoctorDto updateDoctor(Long doctorId, DoctorDto DoctorDto);
    void deleteDoctor(Long doctorId);
    DoctorDto getDoctorById(Long doctorId);
    List<DoctorDto> getAllDoctors();
}