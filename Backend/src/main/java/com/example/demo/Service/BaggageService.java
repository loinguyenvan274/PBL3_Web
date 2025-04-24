package com.example.demo.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.Repository.BaggageRepo;
import com.example.demo.Model.Baggage;
import java.util.List;
import com.example.demo.Enum.TypeBaggage;

@Service
public class BaggageService {
    @Autowired
    private BaggageRepo baggageRepo;

    public List<Baggage> getAllBaggage() {
        return baggageRepo.findAll();
    }

    public Baggage getBaggageById(int idBaggage) {
        return baggageRepo.findByIdBaggage(idBaggage);
    }

    public List<Baggage> getBaggageByType(TypeBaggage baggageType) {
        return baggageRepo.findByBaggageType(baggageType);
    }
}
