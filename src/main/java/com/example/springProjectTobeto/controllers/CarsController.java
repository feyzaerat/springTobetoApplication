package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.services.dtos.requests.car.AddCarRequest;
import com.example.springProjectTobeto.services.dtos.requests.car.UpdateCarRequest;
import com.example.springProjectTobeto.services.dtos.responses.car.GetCarResponse;
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
    public void add(@RequestBody AddCarRequest carForDto){

        Car car = new Car();

        car.setModelName(carForDto.getModelName());
        car.setModelYear(carForDto.getModelYear());
        car.setIsActive(carForDto.getIsActive());
        car.setRank(carForDto.getRank());

        carRepository.save(car);
    }

    @PutMapping("{id}")
    public void updateCar(@PathVariable int id, @RequestBody UpdateCarRequest carForUpdateDto){
        Car updateCar = carRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no id"));
        updateCar.setModelName(carForUpdateDto.getModelName());
        updateCar.setModelYear(carForUpdateDto.getModelYear());


        carRepository.save(updateCar);
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable int id){
        Car deleteCar = carRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no id"));
        carRepository.delete(deleteCar);
    }
}
