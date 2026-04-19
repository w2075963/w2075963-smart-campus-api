/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampus.service;

import com.smartcampus.model.Sensor;
import com.smartcampus.exception.LinkedResourceNotFoundException;
import java.util.*;

public class SensorService{
    private static Map<String, Sensor> sensors = new HashMap<>();
    private RoomService roomService =new RoomService();

    public List<Sensor> getAllSensors(String type){
        if (type == null) return new ArrayList<>(sensors.values());

        List<Sensor> filtered = new ArrayList<>();
        for (Sensor s : sensors.values()){
            if (s.getType().equalsIgnoreCase(type)){
                filtered.add(s);
            }
        }
        return filtered;
    }

    public Sensor addSensor(Sensor sensor){
        if (!roomService.exists(sensor.getRoomId())){
            throw new LinkedResourceNotFoundException("Room does not exist");
        }
        sensors.put(sensor.getId(), sensor);
        return sensor;
    }

    public Sensor getSensor(String id){
        return sensors.get(id);
    }
}
