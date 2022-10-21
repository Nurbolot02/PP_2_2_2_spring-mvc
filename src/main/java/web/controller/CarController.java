package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.Cars;

import java.util.Optional;

@Controller
public class CarController {
    private final Cars cars;

    @Autowired
    public CarController(Cars cars) {
        this.cars = cars;
    }

    @GetMapping("/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap modelMap) {
        StringBuilder result = new StringBuilder();
        Optional<Integer> optional = Optional.ofNullable(count);
        if (optional.isPresent()) {
            result = getCars(count);
        } else {
            result = getCars();
        }
        modelMap.addAttribute("mes", result);
        return "cars";
    }

    private StringBuilder getCars() {
        return getCars(cars.size());
    }

    private StringBuilder getCars(int count) {
        StringBuilder result = new StringBuilder(count);
        for (int i = 0; i < cars.size() && i < count; i++) {
            result.append(cars.getCarByIndex(i)).append("\n");
        }
        return result;
    }
}
