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

import com.lv.hims.beans.dto.AppointmentDto;
import com.lv.hims.service.AppointmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDto> createAppointment(@Validated @RequestBody AppointmentDto AppointmentDto) {
        AppointmentDto createdAppointment = appointmentService.createAppointment(AppointmentDto);
        return ResponseEntity.ok(createdAppointment);
    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable Long appointmentId, @Validated @RequestBody AppointmentDto AppointmentDto) {
        AppointmentDto updatedAppointment = appointmentService.updateAppointment(appointmentId, AppointmentDto);
        return ResponseEntity.ok(updatedAppointment);
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{appointmentId}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long appointmentId) {
        AppointmentDto appointment = appointmentService.getAppointmentById(appointmentId);
        return ResponseEntity.ok(appointment);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
        List<AppointmentDto> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }
}

