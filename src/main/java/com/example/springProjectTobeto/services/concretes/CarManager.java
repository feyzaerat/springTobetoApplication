package com.example.springProjectTobeto.services.concretes;

import com.example.springProjectTobeto.entities.Car;
import com.example.springProjectTobeto.repositories.CarRepository;
import com.example.springProjectTobeto.services.abstracts.CarService;
import com.example.springProjectTobeto.services.dtos.requests.car.AddCarRequest;
import com.example.springProjectTobeto.services.dtos.requests.car.UpdateCarRequest;
import com.example.springProjectTobeto.services.dtos.responses.car.GetCarListResponse;
import com.example.springProjectTobeto.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;

    @Override
    public List<Car> getAll() {
        List<Car> carList = carRepository.findAll();
        List<GetCarListResponse> getCarListResponses = new ArrayList<>();
        return carRepository.findAll();
    }

    @Override
    public GetCarResponse getById(int id) {
        Car car = carRepository.findById(id).orElseThrow();

        GetCarResponse dto = new GetCarResponse();
        dto.setModelName(car.getName());
        dto.setModelYear(car.getModelYear());
        /* dto.setId(car.getBrand());*/

        return dto;

    }

    @Override
    public void addCar(AddCarRequest addCarRequest) {

        boolean result = carRepository.existsByName(addCarRequest.getName().trim());

        if (result) {
            throw new RuntimeException("The model name has to be unique !!");
        }
        Car car = new Car();
        car.setName(addCarRequest.getName());
        car.setModelYear(addCarRequest.getModelYear());


        carRepository.save(car);


    }

    @Override
    public void updateCar(@PathVariable int id, UpdateCarRequest updateCarRequest) {
        Car updateCar = carRepository.findById(id).orElseThrow();
        updateCar.setName(updateCarRequest.getName());

        this.carRepository.save(updateCar);
    }

    @Override
    public void deleteCar(int id) {
        this.carRepository.deleteById(id);
    }

    @Override
    public List<GetCarListResponse> getByName(String name, int id) {
        List<Car> cars = carRepository.findByNameLikeOrIdEquals("%" + name + "%", id);
        List<GetCarListResponse> response = new ArrayList<>();

        for (Car car : cars) {
            response.add(new GetCarListResponse(car.getName()));
        }
        return response;
    }

    @Override
    public List<GetCarListResponse> searchAsLike(String name){
        List<Car> cars = carRepository.searchAsValue(name);
        return carRepository.searchAsList(name);
    }
}
