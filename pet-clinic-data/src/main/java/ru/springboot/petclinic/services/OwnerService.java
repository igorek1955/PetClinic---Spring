package ru.springboot.petclinic.services;

import ru.springboot.petclinic.model.Owner;



public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
