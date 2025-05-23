package com.pbl.flightapp.Controller;

import com.pbl.flightapp.Enum.Status;
import com.pbl.flightapp.Model.Flight;
import com.pbl.flightapp.Model.Location;
import com.pbl.flightapp.Model.Plane;
import com.pbl.flightapp.Repository.LocationRepo;
import com.pbl.flightapp.Service.FlightService;
import com.pbl.flightapp.Service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/plane")
public class PlaneController {
    @Autowired
    private PlaneService planeService;
    
    // Get all planes
    @GetMapping("/all_plane")
    public List<Plane> getAllPlanes() {
        return planeService.getAllPlane();
    }

    // Get plane by id
    @GetMapping("/{id}")
    public Plane getPlaneById(@PathVariable int id) {
        return planeService.getPlaneById(id);
    }

//    // Get planes by name
//    @GetMapping("/name/{name}")
//    public List<Plane> getPlaneByName(@PathVariable String name) {
//        return planeService.getPlaneByName(name);
//    }

    // Get planes by seat count
//    @GetMapping("/seats/{count}")
//    public List<Plane> getPlaneBySeatCount(@PathVariable int count) {
//        return planeService.getPlaneBySeatCount(count);
//    }

    // Create a new plane
    @PostMapping("")
    public void addPlane(@RequestBody Plane plane) {
        planeService.addPlane(plane);
    }

    // Update a plane
    @PutMapping("")
    public void updatePlane(@RequestBody Plane plane) {
        planeService.updatePlane(plane);
    }

    // Delete a plane by ID
    @DeleteMapping("/{id}")
    public void deletePlane(@PathVariable int id) {
        planeService.deletePlane(id);
    }

    // Update only the status of a plane
    @PatchMapping("/{id}/status")
    public void updatePlaneStatus(@PathVariable int id, @RequestParam Status status) {
        planeService.updatePlaneStatus(id, status);
    }
}
