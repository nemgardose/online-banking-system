package com.userfrontend.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.userfrontend.model.Appointment;

public interface AppointmentDao extends CrudRepository<Appointment, Long>{
	
	List<Appointment> findAll();

}
