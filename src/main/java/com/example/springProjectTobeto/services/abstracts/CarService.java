package com.example.springProjectTobeto.services.abstracts;

import com.example.springProjectTobeto.entities.Car;
import com.example.springProjectTobeto.services.dtos.requests.car.AddCarRequest;
import com.example.springProjectTobeto.services.dtos.requests.car.UpdateCarRequest;
import com.example.springProjectTobeto.services.dtos.responses.car.GetCarListResponse;
import com.example.springProjectTobeto.services.dtos.responses.car.GetCarResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CarService {

    List<Car> getAll();

    GetCarResponse getById(int id);

    void addCar(AddCarRequest addCarRequest);

    void updateCar(@PathVariable int id, UpdateCarRequest updateCarRequest);

    void deleteCar(int id);

    List<GetCarListResponse> getByName(String name, int id);
}
