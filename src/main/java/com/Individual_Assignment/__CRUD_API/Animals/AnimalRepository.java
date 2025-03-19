package com.Individual_Assignment.__CRUD_API.Animals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides the actual database transactions.
 * Communicates with database.
 */
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    /**
     * Find a specific Animal by its name.
     *
     * @param name the name of the Animal to retrieve.
     * @return a specific Animal object.
     */
    @Query(value = "select * from animals a where a.name like %?1% ", nativeQuery = true)
    List<Animal> findAnimalByName(String name);

    /**
     * Find a specific Animal by its ID.
     *
     * @param animalId the ID of the Animal to retrieve.
     * @return a specific Animal object.
     */
    @Query("SELECT a FROM Animal a WHERE a.animalId = ?1")
    Animal findAnimalById(int animalId);

    /**
     * Find all Animals in the database.
     *
     * @return a list of all Animals.
     */
    @Query("SELECT a FROM Animal a")
    List<Animal> findAllAnimals();



}
