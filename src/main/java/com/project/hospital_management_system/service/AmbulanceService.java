package com.project.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management_system.dao.AmbulanceDao;
import com.project.hospital_management_system.dto.Ambulance;
import com.project.hospital_management_system.exception.AmbulanceIdNotFound;
import com.project.hospital_management_system.util.ResponseStructure;

@Service
public class AmbulanceService {

	@Autowired
	AmbulanceDao ambulanceDao;

	@Autowired
	ResponseStructure<Ambulance> responseStructure;

	public ResponseEntity<ResponseStructure<Ambulance>> saveAmbulance(Ambulance ambulance) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Ambulance created in DB");
		responseStructure.setData(ambulanceDao.saveAmbulance(ambulance));
		return new ResponseEntity<ResponseStructure<Ambulance>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Ambulance>> fetchAmbulanceById(int ambulanceId) {
		Ambulance ambulance = ambulanceDao.fetchAmbulanceById(ambulanceId);
		if (ambulance != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Ambulance fetched from DB");
			responseStructure.setData(ambulance);
			return new ResponseEntity<ResponseStructure<Ambulance>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new AmbulanceIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Ambulance>> deleteAmbulanceById(int ambulanceId) {
		Ambulance ambulance = ambulanceDao.fetchAmbulanceById(ambulanceId);
		if (ambulance != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Ambulance deleted from DB");
			responseStructure.setData(ambulanceDao.deleteAmbulanceById(ambulanceId));
			return new ResponseEntity<ResponseStructure<Ambulance>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AmbulanceIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Ambulance>> updateAmbulanceById(int oldAmbulanceId, Ambulance newAmbulance) {
		Ambulance ambulance = ambulanceDao.fetchAmbulanceById(oldAmbulanceId);
		if (ambulance != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Ambulance updated in DB");
			responseStructure.setData(ambulanceDao.updateAmbulanceById(oldAmbulanceId, newAmbulance));
			return new ResponseEntity<ResponseStructure<Ambulance>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AmbulanceIdNotFound();
		}
	}

	public List<Ambulance> fetchAllAmbulance() {
		return ambulanceDao.fetchAllAmbulance();
	}
}