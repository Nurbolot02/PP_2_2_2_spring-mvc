package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Cars {
    private List<Car> carList = new ArrayList<>(Arrays.asList(
            new Car(1, "audi", 55),
            new Car(2, "mers", 44),
            new Car(3, "bent-ly", 33),
            new Car(4, "lexus", 22),
            new Car(5, "lambo", 11)
    ));

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public Cars() {
    }

    public int size() {
        return carList.size();
    }

    public Car getCarByIndex(int index) {
        return carList.get(index);
    }

    public List<Car> getCarList(int start, int end) {
        return carList.subList(start, end);
    }

    public List<Car> getCarList(int count) {
        return carList.subList(0, count);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
