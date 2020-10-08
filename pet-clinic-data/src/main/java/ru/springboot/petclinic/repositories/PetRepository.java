package ru.springboot.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.springboot.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
