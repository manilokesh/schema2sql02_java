package com.lv.hims.service;

import java.util.List;

import com.lv.hims.beans.dto.AppointmentDto;

public interface AppointmentService {
    AppointmentDto createAppointment(AppointmentDto AppointmentDto);
    AppointmentDto updateAppointment(Long appointmentId, AppointmentDto AppointmentDto);
    void deleteAppointment(Long appointmentId);
    AppointmentDto getAppointmentById(Long appointmentId);
    List<AppointmentDto> getAllAppointments();
}
