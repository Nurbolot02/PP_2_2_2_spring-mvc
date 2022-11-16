package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CarService {
    private List<Car> carList = new ArrayList<>(Arrays.asList(
            new Car(1, "audi", 55),
            new Car(2, "mers", 44),
            new Car(3, "bent-ly", 33),
            new Car(4, "lexus", 22),
            new Car(5, "lambo", 11)
    ));

    public CarService(List<Car> carList) {
        this.carList = carList;
    }

    public CarService() {
    }

    public int size() {
        return carList.size();
    }

    public List<Car> getCarList(Integer count) {
        Optional<Integer> optional = Optional.ofNullable(count);
        if (optional.isPresent()) {
            return carList.subList(0, count);
        } else {
            return carList;
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

}
