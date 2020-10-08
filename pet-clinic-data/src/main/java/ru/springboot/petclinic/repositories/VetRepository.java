package ru.springboot.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.springboot.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
