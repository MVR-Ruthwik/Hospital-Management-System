package com.project.hospital_management_system.dao;


	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;

	import com.project.hospital_management_system.dto.Address;
import com.project.hospital_management_system.repo.AddressRepo;

	//@Repository is a class level annotation
	//which is responsible to communicate with DB

	@Repository
	public class AddressDao {

		@Autowired
		AddressRepo addressRepo;

		
		public Address saveAddress(Address address) {
//			Address dbAddress = AddressRepo.save(Address);
//			return dbAddress;
			return addressRepo.save(address);
		}

		public Address fetchAddressById(int addressId) {
			Optional<Address> address = addressRepo.findById(addressId);
			if (address.isEmpty()) {
				return null;
			} else {
				return address.get();
			}
//			if (address.isPresent()) {
//				return Address.get();
//			} else {
//				return null;
//			}
		}

		public Address deleteAddressById(int addressId) {
			// Address address = AddressRepo.findById(AddressId).get();
			Address address = fetchAddressById(addressId);
			addressRepo.delete(address);
			return address;
		}

		public Address updateAddressById(int oldAddressId, Address newAddress) {
			newAddress.setAddressId(oldAddressId);
			return addressRepo.save(newAddress);
		}

		public List<Address> fetchAllAddress() {
			return addressRepo.findAll();
		}

		

	}



