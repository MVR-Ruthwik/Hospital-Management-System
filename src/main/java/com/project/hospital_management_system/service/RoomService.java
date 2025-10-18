package com.project.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management_system.dao.RoomDao;
import com.project.hospital_management_system.dto.Room;
import com.project.hospital_management_system.exception.RoomIdNotFound;
import com.project.hospital_management_system.util.ResponseStructure;

@Service
public class RoomService {

	@Autowired
	RoomDao roomDao;

	@Autowired
	ResponseStructure<Room> responseStructure;

	public ResponseEntity<ResponseStructure<Room>> saveRoom(Room room) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Room created in DB");
		responseStructure.setData(roomDao.saveRoom(room));
		return new ResponseEntity<ResponseStructure<Room>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Room>> fetchRoomById(int roomId) {
		Room room = roomDao.fetchRoomById(roomId);
		if (room != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Room fetched from DB");
			responseStructure.setData(room);
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new RoomIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Room>> deleteRoomById(int roomId) {
		Room room = roomDao.fetchRoomById(roomId);
		if (room != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Room deleted from DB");
			responseStructure.setData(roomDao.deleteRoomById(roomId));
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure, HttpStatus.OK);
		} else {
			throw new RoomIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Room>> updateRoomById(int oldRoomId, Room newRoom) {
		Room room = roomDao.fetchRoomById(oldRoomId);
		if (room != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Room updated in DB");
			responseStructure.setData(roomDao.updateRoomById(oldRoomId, newRoom));
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure, HttpStatus.OK);
		} else {
			throw new RoomIdNotFound();
		}
	}

	public List<Room> fetchAllRoom() {
		return roomDao.fetchAllRoom();
	}
}

