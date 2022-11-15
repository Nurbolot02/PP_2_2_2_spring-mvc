package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.Optional;

@Controller
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap modelMap) {
        Optional<Integer> optional = Optional.ofNullable(count);
        if (optional.isPresent()) {
            modelMap.addAttribute("mes", carService.getCarList(count));
        } else {
            modelMap.addAttribute("mes", carService.getCarList());
        }

        return "cars";
    }
}
