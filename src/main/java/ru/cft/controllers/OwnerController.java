package ru.cft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.cft.entity.Owner;
import ru.cft.service.OwnerService;

import java.util.List;

@Controller
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/owners")
    public String showAllOwners(Model model){
        List<Owner> owners = ownerService.getAllOwners();
        System.out.println("Laalalallalal");
        System.out.println(owners.isEmpty());
        System.out.println(owners == null);
        model.addAttribute("owners", owners);
        return "owner-list";
    }

    @GetMapping("/owner-create")
    public String createOwnerForm(Owner owner){
        return "owner-create";
    }

    @PostMapping("/owner-create")
    public String createOwner(Owner owner){
        System.out.println(owner.getFirstName());
        boolean isAdded = ownerService.addOwner(owner);
        if(isAdded) {
            return "redirect:/owners";
        }else {
            return "redirect:/owner-create-error";
        }
    }

    @GetMapping("/owner-create-error")
    public String createOwnerErrorForm(){
        return "owner-create-error";
    }

    @PostMapping("/owner-create-error")
    public String createOwnerError(){
        return "redirect:/owner-create";
    }

    @GetMapping("/owner-delete/{id}")
    public String deleteOwner(@PathVariable("id") Long id){
        ownerService.deleteOwner(id);
        return "redirect:/owners";
    }


}
