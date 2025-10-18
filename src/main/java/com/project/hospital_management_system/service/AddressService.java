package com.project.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management_system.dao.AddressDao;
import com.project.hospital_management_system.dto.Address;
import com.project.hospital_management_system.exception.AddressIdNotFound;
import com.project.hospital_management_system.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	AddressDao addressDao;

	@Autowired
	ResponseStructure<Address> responseStructure;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Address created in DB");
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int addressId) {
		Address address = addressDao.fetchAddressById(addressId);
		if (address != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Address fetched from DB");
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int addressId) {
		Address address = addressDao.fetchAddressById(addressId);
		if (address != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Address deleted from DB");
			responseStructure.setData(addressDao.deleteAddressById(addressId));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddressById(int oldAddressId, Address newAddress) {
		Address address = addressDao.fetchAddressById(oldAddressId);
		if (address != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Address updated in DB");
			responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AddressIdNotFound();
		}
	}

	public List<Address> fetchAllAddress() {
		return addressDao.fetchAllAddress();
	}}
