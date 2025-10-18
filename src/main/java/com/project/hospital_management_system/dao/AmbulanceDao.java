package com.project.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system.dto.Ambulance;
import com.project.hospital_management_system.repo.AmbulanceRepo;
@Repository
public class AmbulanceDao {
	@Autowired
    AmbulanceRepo ambulanceRepo;
	@Autowired
	BranchDao branchDao;
	public Ambulance saveAmbulance(Ambulance Ambulance) {
//		Ambulance dbAmbulance = AmbulanceRepo.save(Ambulance);
//		return dbAmbulance;
		//return AmbulanceRepo.save(Ambulance);
		return ambulanceRepo.save(Ambulance);
	}

	public Ambulance fetchAmbulanceById(int AmbulanceId) {
		Optional<Ambulance> ambulance = ambulanceRepo.findById(AmbulanceId);
		if (ambulance.isEmpty()) {
			return null;
		} else {
			return ambulance.get();
		}
//		if (Ambulance.isPresent()) {
//			return Ambulance.get();
//		} else {
//			return null;
//		}
	}

	public Ambulance deleteAmbulanceById(int AmbulanceId) {
		// Ambulance ambulance = ambulanceRepo.findById(AmbulanceId).get();
		Ambulance ambulance = fetchAmbulanceById(AmbulanceId);
		ambulanceRepo.delete(ambulance);
		return ambulance;
	}

	public Ambulance updateAmbulanceById(int oldAmbulanceId, Ambulance newAmbulance) {
		newAmbulance.setAmbulanceId(oldAmbulanceId);
		return ambulanceRepo.save(newAmbulance);
	}

	public List<Ambulance> fetchAllAmbulance() {
		return ambulanceRepo.findAll();
	}

	
		
		
	}




