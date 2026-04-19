/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampus.resource;

import com.smartcampus.model.Sensor;
import com.smartcampus.service.SensorService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

@Path("/sensors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorResource{
    SensorService service = new SensorService();

    @GET
    public List<Sensor> getSensors(@QueryParam("type") String type){
        return service.getAllSensors(type);
    }

    
    @POST
    public Response addSensor(Sensor sensor){
        return Response.status(201).entity(service.addSensor(sensor)).build();
    }

    @Path("/{id}/readings")
    public SensorReadingResource getReadingResource(){
        return new SensorReadingResource();
    }
    
    
    
}
