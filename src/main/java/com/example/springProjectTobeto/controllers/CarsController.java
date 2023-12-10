package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.entities.Car;
import com.example.springProjectTobeto.services.abstracts.CarService;
import com.example.springProjectTobeto.services.dtos.requests.car.AddCarRequest;
import com.example.springProjectTobeto.services.dtos.requests.car.UpdateCarRequest;
import com.example.springProjectTobeto.services.dtos.responses.car.GetCarListResponse;
import com.example.springProjectTobeto.services.dtos.responses.car.GetCarResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")

public class CarsController {
    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCarList() {

        return this.carService.getAll();

    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id) {
        return this.carService.getById(id);
    }

    @PostMapping
    public void addCarr(@RequestBody @Valid AddCarRequest addCarRequest) {
        this.carService.addCar(addCarRequest);
    }

    @PutMapping("{id}")
    public void updateCar(@PathVariable int id, @RequestBody UpdateCarRequest updateCarRequest) throws Exception {
        this.carService.updateCar(id, updateCarRequest);
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable int id) {
        this.carService.deleteCar(id);
    }

    @GetMapping("getName")
    public List<GetCarListResponse> getByName(@RequestParam String name, @RequestParam int id) {
        return this.carService.getByName(name, id);
    }
}
