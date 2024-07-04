package com.lv.hims.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.lv.hims.beans.dto.AppointmentDto;
import com.lv.hims.entity.Appointment;
import com.lv.hims.repository.AppointmentRepository;
import com.lv.hims.service.AppointmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public AppointmentDto createAppointment(AppointmentDto AppointmentDto) {
        Appointment appointment = modelMapper.map(AppointmentDto, Appointment.class);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return modelMapper.map(savedAppointment, AppointmentDto.class);
    }

    @Override
    public AppointmentDto updateAppointment(Long appointmentId, AppointmentDto AppointmentDto) {
        Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new RuntimeException("Appointment not found"));
        modelMapper.map(AppointmentDto, existingAppointment);
        Appointment updatedAppointment = appointmentRepository.save(existingAppointment);
        return modelMapper.map(updatedAppointment, AppointmentDto.class);
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public AppointmentDto getAppointmentById(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new RuntimeException("Appointment not found"));
        return modelMapper.map(appointment, AppointmentDto.class);
    }

    @Override
    public List<AppointmentDto> getAllAppointments() {
        return appointmentRepository.findAll().stream()
                .map(appointment -> modelMapper.map(appointment, AppointmentDto.class))
                .collect(Collectors.toList());
    }
}
