package com.pbl.flightapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pbl.flightapp.Repository.SeatRepo;
import com.pbl.flightapp.Repository.PlaneRepo;
import com.pbl.flightapp.Model.Plane;
import com.pbl.flightapp.Enum.Status;

@Service
public class PlaneService {
    @Autowired
    private PlaneRepo planeRepo;
    @Autowired
    private SeatRepo seatRepo;

    public PlaneService() {
    }

    public PlaneService(PlaneRepo planeRepo) {
        this.planeRepo = planeRepo;
    }

    public List<Plane> getAllPlane() {
        List<Plane> allPlane = planeRepo.findAll();
        allPlane.forEach(plane -> plane.setSeatCount(seatRepo.countByPlane(plane)));
        return allPlane;
    }

    public Plane getPlaneById(int idPlane) {
        return planeRepo.findByIdPlane(idPlane);
    }

    public List<Plane> getPlaneByName(String namePlane) {
        return planeRepo.findByNamePlane(namePlane);
    }

    // public List<Plane> getPlaneBySeatCount(int seatCount) {
    // return planeRepo.findBySeatCount(seatCount);
    // }

    public void deletePlane(int idPlane) {
        planeRepo.deleteById(idPlane);
    }

    public void addPlane(Plane plane) {
        planeRepo.save(plane);
    }

    @Transactional
    public void updatePlane(int idPlane, Plane plane) {
        Plane exist = planeRepo.findByIdPlane(idPlane);
        if (exist == null) {
            throw new RuntimeException("Plane not found");
        }
        exist.CopyFrom(plane);
    }

    public void updatePlaneStatus(int idPlane, Status status) {
        Plane plane = planeRepo.findByIdPlane(idPlane);
        if (plane != null) {
            plane.setStatus(status);
            planeRepo.save(plane);
        }
    }
}
