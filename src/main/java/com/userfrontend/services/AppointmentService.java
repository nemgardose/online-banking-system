package com.userfrontend.services;

import java.util.List;

import com.userfrontend.model.Appointment;

public interface AppointmentService {
	
	Appointment createAppointment(Appointment appointment);
	List<Appointment> findAll();
	Appointment findAppointment(Long id);
	void confirmAppointment(Long id);
}
