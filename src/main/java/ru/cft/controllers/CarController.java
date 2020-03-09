package ru.cft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.cft.entity.Car;
import ru.cft.entity.Owner;
import ru.cft.service.CarService;
import ru.cft.service.OwnerService;


import java.util.List;

@Controller
public class CarController {
    private  final CarService carService;
    private  final OwnerService ownerService;

    @Autowired
    public CarController(CarService carService, OwnerService ownerService) {
        this.carService = carService;
        this.ownerService = ownerService;
    }


//===================================Mapping for RETRIEVE======================================================

    @GetMapping("/cars")
    public String showAllOwners(Model model){
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "car-list";
    }


//===================================Mapping for CREATE======================================================

    @GetMapping("/car-create")
    public String createOwnerForm(Car car, Model model){
        List<Owner> owners = ownerService.getAllOwners();
        model.addAttribute("owners", owners);
        return "car-create";
    }

    @PostMapping("/car-create")
    public String createOwner(Car car){
        boolean isAdded = carService.addCar(car);
        if(isAdded) {
            return "redirect:/cars";
        }else {
            return "redirect:/car-create-error";
        }
    }

    /**
     * @return веб страницу с сообщением об ошибке, при неверно введенных данных
     */
    @GetMapping("/car-create-error")
    public String createOwnerErrorForm(){
        return "car-create-error";
    }

    /**
     * @return веб страницу для добавления {@link Car} в базу данных
     */
    @PostMapping("/car-create-error")
    public String createOwnerError() {
        return "redirect:/car-create";
    }




//===================================Exception Handling======================================================

    /**
     * Обработчик исключения, возникающего при путом поле Production Date во время добавления {@link Car}
     * @return веб страницу с сообщением об ошибке, при неверно введенных данных
     */
    @ExceptionHandler(BindException.class)
    public String handleIAE(){
        return "redirect:/car-create-error";
    }

}