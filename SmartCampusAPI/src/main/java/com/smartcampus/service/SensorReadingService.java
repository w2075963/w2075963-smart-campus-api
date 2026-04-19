/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampus.service;

import com.smartcampus.model.SensorReading;
import com.smartcampus.model.Sensor;
import com.smartcampus.exception.SensorUnavailableException;
import java.util.*;

/**
 *
 * @author muamm
 */
public class SensorReadingService{
    private static Map<String, List<SensorReading>> readings = new HashMap<>();
    private SensorService sensorService = new SensorService();

    public List<SensorReading> getReadings(String sensorId){
        return readings.getOrDefault(sensorId, new ArrayList<>());
    }

    public SensorReading addReading(String sensorId, SensorReading reading){
        Sensor sensor = sensorService.getSensor(sensorId);

        if (sensor.getStatus().equals("MAINTENANCE")){
            throw new SensorUnavailableException("Sensor unavailable");
        }

        readings.putIfAbsent(sensorId, new ArrayList<>());
        readings.get(sensorId).add(reading);

        sensor.setCurrentValue(reading.getValue());

        return reading;
    }
}
