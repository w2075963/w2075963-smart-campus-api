/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampus.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.*;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class DiscoveryResource{

    @GET
    public Map<String, Object> getInfo(){
        Map<String, Object> map = new HashMap<>();
        map.put("version", "v1");
        map.put("rooms", "/api/v1/rooms");
        map.put("sensors", "/api/v1/sensors");
        return map;
    }
}
