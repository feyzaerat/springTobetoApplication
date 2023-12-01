package com.example.springProjectTobeto.services.concretes;

import com.example.springProjectTobeto.entities.Car;
import com.example.springProjectTobeto.repositories.CarRepository;
import com.example.springProjectTobeto.services.abstracts.CarService;
import com.example.springProjectTobeto.services.dtos.requests.car.AddCarRequest;
import com.example.springProjectTobeto.services.dtos.requests.car.UpdateCarRequest;
import com.example.springProjectTobeto.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;

    @Override
    public List<Car> getAll(){
        return carRepository.findAll();
    }
    @Override
    public GetCarResponse getById(int id){
        Car car = carRepository.findById(id).orElseThrow();

        GetCarResponse dto = new GetCarResponse();
        dto.setModelName(car.getModelName());
        dto.setModelYear(car.getModelYear());

        return dto;

    }
    @Override
    public void addCar(AddCarRequest addCarRequest){
       Car car = new Car();
       car.setModelName(addCarRequest.getModelName());
       car.setModelYear(addCarRequest.getModelYear());

       carRepository.save(car);


    }
    @Override
    public void updateCar(@PathVariable int id, UpdateCarRequest updateCarRequest){
        Car updateCar = carRepository.findById(id).orElseThrow();
        updateCar.setModelName(updateCarRequest.getModelName());
        updateCar.setModelYear(updateCarRequest.getModelYear());

        this.carRepository.save(updateCar);
    }

    @Override
    public void deleteCar(int id){
        this.carRepository.deleteById(id);
    }
}
