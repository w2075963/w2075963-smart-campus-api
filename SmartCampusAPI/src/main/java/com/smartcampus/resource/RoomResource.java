/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampus.resource;

import com.smartcampus.model.Room;
import com.smartcampus.service.RoomService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource{

    RoomService service = new RoomService();
    @GET
    public List<Room>getRooms(){
        return service.getAllRooms();
    }

    @POST
    public Response addRoom(Room room){
        return Response.status(Response.Status.CREATED)
        .entity(room)
        .header("Location", "/api/v1/rooms/" + room.getId())
        .build();
    }

    @GET
    @Path("/{id}")
    public Room getRoom(@PathParam("id") String id){
        return service.getRoom(id);
    }
    @DELETE
    @Path("/{id}")
    public Response deleteRoom(@PathParam("id") String id){
        service.deleteRoom(id);
        return Response.ok().build();
    }
}
