package com.project.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system.dto.Room;
import com.project.hospital_management_system.repo.RoomRepo;
@Repository
public class RoomDao {
	@Autowired
	RoomRepo roomRepo;

	
	public Room saveRoom(Room room) {
//		Room dbRoom = RoomRepo.save(room);
//		return dbRoom;
		return roomRepo.save(room);
	}

	public Room fetchRoomById(int roomId) {
		Optional<Room> room = roomRepo.findById(roomId);
		if (room.isEmpty()) {
			return null;
		} else {
			return room.get();
		}
//		if (room.isPresent()) {
//			return room.get();
//		} else {
//			return null;
//		}
	}

	public Room deleteRoomById(int roomId) {
		// Room room = roomRepo.findById(roomId).get();
		Room room = fetchRoomById(roomId);
		roomRepo.delete(room);
		return room;
	}

	public Room updateRoomById(int oldRoomId, Room newRoom) {
		newRoom.setRoomId(oldRoomId);
		return roomRepo.save(newRoom);
	}

	public List<Room> fetchAllRoom() {
		return roomRepo.findAll();
	}

	


}
