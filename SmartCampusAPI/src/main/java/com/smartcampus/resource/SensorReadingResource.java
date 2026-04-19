/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampus.resource;

import com.smartcampus.model.SensorReading;
import com.smartcampus.service.SensorReadingService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
/**
 *
 * @author muamm
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorReadingResource {

    SensorReadingService service = new SensorReadingService();

    @GET
    public List<SensorReading>getReadings(@PathParam("id")String sensorId){
        return service.getReadings(sensorId);
    }
    @POST
    public SensorReading addReading(@PathParam("id")String sensorId, SensorReading reading){
        return service.addReading(sensorId, reading);
        
    }
}


