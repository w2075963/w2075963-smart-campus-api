/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampus.service;

import com.smartcampus.model.Room;
import com.smartcampus.exception.RoomNotEmptyException;
import java.util.*;

public class RoomService{
    private static Map<String, Room> rooms = new HashMap<>();

    public List<Room> getAllRooms(){
        return new ArrayList<>(rooms.values());
    }

    public Room getRoom(String id){
        return rooms.get(id);
    }

    public Room addRoom(Room room){
        rooms.put(room.getId(), room);
        return room;
    }

    public void deleteRoom(String id){
        Room room = rooms.get(id);

        if (room != null && !room.getSensorIds().isEmpty()) {
            throw new RoomNotEmptyException("Room has sensors assigned");
        }

        rooms.remove(id);
    }

    public boolean exists(String id){
        return rooms.containsKey(id);
    }
}
