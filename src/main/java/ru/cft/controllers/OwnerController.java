package ru.cft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.cft.entity.Owner;
import ru.cft.service.CarService;
import ru.cft.service.OwnerService;

import java.util.List;

@Controller
public class OwnerController {
    private  final CarService carService;
    private  final OwnerService ownerService;

    @Autowired
    public OwnerController(CarService carService, OwnerService ownerService) {
        this.carService = carService;
        this.ownerService = ownerService;
    }

//===================================Mapping for RETRIEVE======================================================

    @GetMapping("/owners")
    public String showAllOwners(Model model){
        List<Owner> owners = ownerService.getAllOwners();
        model.addAttribute("owners", owners);
        return "owner-list";
    }

//===================================Mapping for CREATE======================================================

    @GetMapping("/owner-create")
    public String createOwnerForm(Owner owner){
        return "owner-create";
    }

    @PostMapping("/owner-create")
    public String createOwner(Owner owner){
        boolean isAdded = ownerService.addOwner(owner);
        if(isAdded) {
            return "redirect:/owners";
        }else {
            return "redirect:/owner-create-error";
        }
    }

    /**
     * @return веб страницу с сообщением об ошибке, при неверно введенных данных
     */
    @GetMapping("/owner-create-error")
    public String createOwnerErrorForm(){
        return "owner-create-error";
    }

    /**
     * @return веб страницу для добавления {@link Owner} в базу данных
     */
    @PostMapping("/owner-create-error")
    public String createOwnerError(){
        return "redirect:/owner-create";
    }


//===================================Mapping for DELETE======================================================

    @GetMapping("/owner-delete/{id}")
    public String deleteOwner(@PathVariable("id") Long id){
        carService.deleteCarByOwnerId(id);
        ownerService.deleteOwner(id);
        return "redirect:/owners";
    }

//===================================Mapping for UPDATE======================================================

    /**
     * @return веб страницу для обнавления {@link Owner} в базе данных
     */
    @GetMapping("/owner-update/{id}")
    public String updateOwnerForm(@PathVariable("id") Long id, Model model){
        Owner owner = ownerService.findById(id);
        model.addAttribute("owner", owner);
        return "owner-update";
    }

    @PostMapping("/owner-update")
    public String updateOwner(Owner owner){
        ownerService.addOwner(owner);
        return "redirect:/owners";
    }




}
