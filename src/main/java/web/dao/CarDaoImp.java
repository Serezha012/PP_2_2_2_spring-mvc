package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao{

    private final List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Audi", "Red", 2020));
        cars.add(new Car("BMW", "Green", 2015));
        cars.add(new Car("Lada", "Yellow", 2010));
        cars.add(new Car("Haval", "Black", 2022));
        cars.add(new Car("Mers", "Red", 2002));
    }


    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getCarsWithParameters(int value) {
        if (value > 5) return cars;

        List<Car> result = new ArrayList<>();
        for (int i = 0; i < value; i++) {
            result.add(cars.get(i));
        }
        return result;
    }

}
