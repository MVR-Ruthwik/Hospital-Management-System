package com.project.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system.dto.Hospital;
import com.project.hospital_management_system.dto.Owner;
import com.project.hospital_management_system.repo.OwnerRepo;

//@Repository is a class level annotation
//which is responsible to communicate with DB

@Repository
public class OwnerDao {

	@Autowired
	OwnerRepo ownerRepo;

	@Autowired
	HospitalDao hospitalDao;

	public Owner saveOwner(Owner owner) {
//		Owner dbOwner = ownerRepo.save(owner);
//		return dbOwner;
		return ownerRepo.save(owner);
	}

	public Owner fetchOwnerById(int ownerId) {
		Optional<Owner> owner = ownerRepo.findById(ownerId);
		if (owner.isEmpty()) {
			return null;
		} else {
			return owner.get();
		}
//		if (owner.isPresent()) {
//			return owner.get();
//		} else {
//			return null;
//		}
	}

	public Owner deleteOwnerById(int ownerId) {
		// Owner owner = ownerRepo.findById(ownerId).get();
		Owner owner = fetchOwnerById(ownerId);
		ownerRepo.delete(owner);
		return owner;
	}

	public Owner updateOwnerById(int oldOwnerId, Owner newOwner) {
		newOwner.setOwnerId(oldOwnerId);
		return ownerRepo.save(newOwner);
	}

	public List<Owner> fetchAllOwner() {
		return ownerRepo.findAll();
	}

	public Owner addExistingOwnerToExistingHospital(int ownerId, int hospitalId) {
		Owner owner = fetchOwnerById(ownerId);
		Hospital hospital = hospitalDao.fetchHospitalById(hospitalId);
		owner.setHospital(hospital);
		return saveOwner(owner);
	}

}
