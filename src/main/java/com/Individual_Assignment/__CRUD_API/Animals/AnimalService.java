package com.Individual_Assignment.__CRUD_API.Animals;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AnimalService.java
 * Provides the actual business logic for the Animal object.
 * Centralizes data access to the Animal database.
 */
@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    /**
     * Get a list of all Animals in the database.
     *
     * @return a list of all Animals.
     */
    public List<Animal> getAllAnimals() {
        return animalRepository.findAllAnimals();
    }

    /**
     * Get a specific Animal by its ID.
     *
     * @param animalId the ID of the Animal to retrieve.
     * @return a specific Animal object.
     */
    public Animal getAnimalById(int animalId) {
        return animalRepository.findAnimalById(animalId);
    }

    /**
     * Get a specific Animal by its name.
     *
     * @param name the name of the Animal to retrieve.
     * @return a specific Animal object.
     */
    public List<Animal> getAnimalByName(String name) {
        return animalRepository.findAnimalByName(name);
    }

    /**
     * Add a new Animal to the database.
     *
     * @param animal the Animal object to add.
     */
    public void addAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    /**
     * Update an existing Animal in the database.
     *
     * @param animal the Animal object to update.
     */
    public void updateAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    /**
     * Delete an existing Animal from the database.
     *
     * @param animalId the ID of the Animal to delete.
     */
    public void deleteAnimal(int animalId) {
        animalRepository.deleteById(animalId);
    }


}