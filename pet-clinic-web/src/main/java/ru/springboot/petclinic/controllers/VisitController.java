package ru.springboot.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.springboot.petclinic.model.Pet;
import ru.springboot.petclinic.model.Visit;
import ru.springboot.petclinic.services.PetService;
import ru.springboot.petclinic.services.VisitService;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

@Controller
@RequestMapping("/owners/")
public class VisitController {

    private final VisitService visitService;
    private final PetService petService;
    private final String VISIT_FORM = "pets/createOrUpdateVisitForm";

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void dataBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
        dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport(){
            @Override
            public void setAsText(String text) throws IllegalArgumentException{
                setValue(LocalDate.parse(text));
            }
        });
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }



    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable("petId") Long id, Model model){
        Pet pet = petService.findById(id);
        model.addAttribute("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        return visit;
    }

    @GetMapping("/*/pets/{petId}/visits/new")
    public String initNewVisitForm(){
        return VISIT_FORM;
    }

    @PostMapping("/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result){
        if(result.hasErrors()){
            return VISIT_FORM;
        } else{
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }
}
