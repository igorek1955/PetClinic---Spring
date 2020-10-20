package ru.springboot.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.springboot.petclinic.model.*;
import ru.springboot.petclinic.services.*;

import java.time.LocalDate;


//component annotation means that spring framework will automatically detect it
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialityService specialityService,
                      VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Igor");
            owner1.setLastName("Kurosaki");
        owner1.setAddress("123 pochtovaya");
        owner1.setCity("Moscow");
        owner1.setTelephone("123454");


        Pet igorPet = new Pet();
        igorPet.setPetType(savedDogType);
        igorPet.setOwner(owner1);
        igorPet.setBirthDate(LocalDate.now());
        igorPet.setName("Petka");
        owner1.getPets().add(igorPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Kuchi");
        owner2.setLastName("Mushi");
        owner2.setAddress("43 sadovaya");
        owner2.setCity("Saint-Petersburg");
        owner2.setTelephone("54534643");

        Pet kuchiPet = new Pet();
        kuchiPet.setPetType(savedCatType);
        kuchiPet.setOwner(owner2);
        kuchiPet.setBirthDate(LocalDate.now());
        kuchiPet.setName("Pumba");
        owner2.getPets().add(kuchiPet);
        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(kuchiPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Cat sneezes");
        visitService.save(catVisit);

        System.out.println("Loaded owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vets....");
    }
}
