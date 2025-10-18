
package com.project.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management_system.dao.OwnerDao;
import com.project.hospital_management_system.dto.Owner;
import com.project.hospital_management_system.exception.OwnerIdNotFound;
import com.project.hospital_management_system.util.ResponseStructure;

// @Service is a class level annotation 
//which is responsible to write Business Logics

@Service
public class OwnerService {

	@Autowired
	OwnerDao ownerDao;

	@Autowired
	ResponseStructure<Owner> responseStructure;

	public ResponseEntity<ResponseStructure<Owner>> saveOwner(Owner owner) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Owner created in DB");
		responseStructure.setData(ownerDao.saveOwner(owner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Ownetr fetched from DB");
			responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Owner deleted from DB");
			responseStructure.setData(ownerDao.deleteOwnerById(ownerId));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Owner>> updateOwnerById(int oldOwnerId, Owner newOwner) {
		Owner owner = ownerDao.fetchOwnerById(oldOwnerId);
		if (owner != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Owner updated in DB");
			responseStructure.setData(ownerDao.updateOwnerById(oldOwnerId, newOwner));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	
	public List<Owner> fetchAllOwner() {
		return ownerDao.fetchAllOwner();
	}

	public Owner addExistingOwnerToExistingHospital(int ownerId, int hospitalId) {
		return ownerDao.addExistingOwnerToExistingHospital(ownerId, hospitalId);
	}
}
