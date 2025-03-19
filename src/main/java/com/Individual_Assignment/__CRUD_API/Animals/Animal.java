package com.Individual_Assignment.__CRUD_API.Animals;

import jakarta.persistence.*; //Persistence api, the jpa in the pom.xlm file.

/**
 * Animal.java
 * Represents the Animal object.
 * Maps the Animal object to the database.
 */

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalId;

    @Column(nullable = false)
    private String name;

    @Column(length = 550, nullable = true)
    private String description;

    public Animal(){
    }

    public Animal(int animalId, String name, String description){
        this.animalId = animalId;
        this.name = name;
        this.description = description;
    }
    
    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
