package com.tonyhotel.tony_is_hotel.controller;

import com.tonyhotel.tony_is_hotel.model.Room;
import com.tonyhotel.tony_is_hotel.response.RoomResponse;
import com.tonyhotel.tony_is_hotel.service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") // Add this annotation
@RequiredArgsConstructor
@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final IRoomService roomService;


    // creating a class to create rooms in the database
    @PostMapping("/add/new-room")
    public ResponseEntity<RoomResponse> addNewRoom(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("roomType") String roomType,
            @RequestParam("roomPrice") BigDecimal roomPrice
    ) throws SQLException, IOException {
        Room room = roomService.addNewRoom(photo, roomType, roomPrice);
        RoomResponse response = new RoomResponse(room.getId(), room.getRoomType(), room.getRoomPrice());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/room/types")
    public List<String> getRoomTypes() {
        List<String> roomTypes = roomService.getAllRoomTypes();
        System.out.println("Fetched Room Types: " + roomTypes); // Debug log
        return roomTypes;
    }
    public ResponseEntity<List<RoomResponse>> getAllRooms(){
        List<Room> rooms = roomService.getAllRoom();
        List<RoomResponse> roomResponses = new ArrayList<>();
        for (Room room : rooms){
            byte[] photoBytes = roomService getRoomPhotoByRoomId(room.getId());
            if(photoBytes != null && photoBytes.length > 0){
                string base64Photo = Base64.encodeBase64String(photoBytes);
                RoomResponse roomResponse = getRoomResponse(room);
                roomResponse.setPhoto(base64Photo);
                roomResponses.add(roomResponse);
            }
        }
        return ResponseEntity.ok(roomResponses);
    }

}
