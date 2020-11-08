package ru.springboot.petclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.springboot.petclinic.model.Pet;
import ru.springboot.petclinic.model.Visit;
import ru.springboot.petclinic.repositories.PetRepository;
import ru.springboot.petclinic.repositories.VisitRepository;
import ru.springboot.petclinic.services.VisitService;

import java.util.*;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private final VisitRepository visitRepository;
    private final PetRepository petRepository;

    public VisitSDJpaService(VisitRepository visitRepository, PetRepository petRepository) {
        this.visitRepository = visitRepository;
        this.petRepository = petRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }

    @Override
    public List<Visit> findByPetId(Long petId) {
        Optional<Pet> petOptional = petRepository.findById(petId);
        Pet pet = null;

        if(petOptional.isPresent()){
            pet = petOptional.get();
        }

        return new ArrayList<>(pet.getVisits());

    }
}
