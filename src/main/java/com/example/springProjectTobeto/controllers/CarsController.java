package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.dtos.requests.car.AddCarRequest;
import com.example.springProjectTobeto.dtos.responses.car.GetCarResponse;
import com.example.springProjectTobeto.entities.Car;
import com.example.springProjectTobeto.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {

    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository){
        this.carRepository =carRepository;
    }

    @GetMapping
    public List<Car> getAll(){
        return carRepository.findAll();
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id){
        Car car = carRepository.findById(id).orElseThrow();

        GetCarResponse dto = new GetCarResponse();
        dto.setModelName(car.getModelName());

        return dto;

    }

    @PostMapping
    public void add(@RequestBody Car car){
        carRepository.save(car);
    }

    @PutMapping("{id}")
    public void updateCar(@PathVariable int id, @RequestBody Car car){
        Car updateCar = carRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no id"));
        updateCar.setId(car.getId());
        updateCar.setModelName(car.getModelName());
        updateCar.setModelYear(car.getModelYear());
        updateCar.setRank(car.getRank());
        updateCar.setIsActive(car.getIsActive());
        updateCar.setBrand(car.getBrand());

        carRepository.save(updateCar);
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable int id){
        Car deleteCar = carRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no id"));
        carRepository.delete(deleteCar);
    }
}
