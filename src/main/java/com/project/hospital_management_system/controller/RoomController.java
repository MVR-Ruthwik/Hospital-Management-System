package com.project.hospital_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.hospital_management_system.dto.Room;
import com.project.hospital_management_system.service.RoomService;
import com.project.hospital_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class RoomController {

	@Autowired
	RoomService roomService;

	@Operation(summary = "Save Room", description = "API to create a new Room")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Room successfully created") })
	@PostMapping("/saveRoom")
	public ResponseEntity<ResponseStructure<Room>> saveRoom(@RequestBody Room room) {
		return roomService.saveRoom(room);
	}

	@Operation(summary = "Fetch Room", description = "API to fetch Room by ID")
	@ApiResponses({ @ApiResponse(responseCode = "302", description = "Room successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Room not found") })
	@GetMapping("/fetchRoomById")
	public ResponseEntity<ResponseStructure<Room>> fetchRoomById(@RequestParam int roomId) {
		return roomService.fetchRoomById(roomId);
	}
	@Operation(summary = "Delete Room by ID", description = "API to delete Room by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Room successfully deleted"),
	    @ApiResponse(responseCode = "404", description = "Room not found with given ID")
	})

	@DeleteMapping("/deleteRoomById")
	public ResponseEntity<ResponseStructure<Room>> deleteRoomById(@RequestParam int roomId) {
		return roomService.deleteRoomById(roomId);
	}
	@Operation(summary = "Update Room by ID", description = "API to update existing Room details by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Room successfully updated"),
	    @ApiResponse(responseCode = "404", description = "Room not found with given ID")
	})

	@PutMapping("/updateRoomById")
	public ResponseEntity<ResponseStructure<Room>> updateRoomById(@RequestParam int oldRoomId,
			@RequestBody Room newRoom) {
		return roomService.updateRoomById(oldRoomId, newRoom);
	}
	@Operation(summary = "Fetch All Rooms", description = "API to retrieve all rooms from the database")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "List of rooms fetched successfully"),
	    @ApiResponse(responseCode = "204", description = "No rooms found")
	})

	@GetMapping("/fetchAllRoom")
	public List<Room> fetchAllRoom() {
		return roomService.fetchAllRoom();
	}
}