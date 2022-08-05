package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;


@Controller
@RequestMapping("/cars")
public class CarsController {

    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String car(@RequestParam(value = "count", required = false) String count, Model model) {
        if (count != null) {
            model.addAttribute("carList", carService.getCarsWithParameters(Integer.parseInt(count)));
            return "cars";
        }

        model.addAttribute("carList", carService.getCars());
        return "cars";
    }


}
