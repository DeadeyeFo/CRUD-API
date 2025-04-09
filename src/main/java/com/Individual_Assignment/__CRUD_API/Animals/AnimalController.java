package com.Individual_Assignment.__CRUD_API.Animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;

/**
 * AnimalController.java.
 * Includes all REST API endpoint mappings for the Student object.
 */
@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired //Dependency injection.
    private AnimalService AnimalService;

    /**
     * Get a list of all Animals in the database.
     * http://localhost:8080/animals/all
     *
     * @return a list of Animal objects.
     */
    @GetMapping("/all")
    public String getAllAnimals(Model model) {
    List<Animal> animals = AnimalService.getAllAnimals(); // Fetching all animals from the service
    model.addAttribute("animalList", animals);// Add the animals to the model
    model.addAttribute("title", "All Animals");// Add a title for the page
    return "animal-list"; // Return the FreeMarker template name ("animal-list.ftlh")
    }

    /**
     * Get a specific Animal by its ID.
     * http://localhost:8080/animals/888
     *
     * @param animalId the ID of the Animal to retrieve.
     * @return a specific Animal object.
     */
    @GetMapping("/{animalId:[0-9]+}")
    public Object getAnimalById(@PathVariable int animalId) {
        return new ResponseEntity<>(AnimalService.getAnimalById(animalId), HttpStatus.OK);
    }

    /**
     * Get a specific Animal by its name.
     * http://localhost:8080/animals/name/Axolotl
     *
     * @param name the name of the Animal to retrieve.
     * @return a specific Animal object.
     */
    @GetMapping("/name")
    public Object getAnimalByName(@RequestParam(name = "search", defaultValue = "") String search, Model model) {
        // return new ResponseEntity<>(AnimalService.getAnimalByName(search), HttpStatus.OK);
        model.addAttribute("animalList", AnimalService.getAnimalByName(search)); // Add the animals to the model
        model.addAttribute("title", "Animal By Name: " + search); // Add a title for the page
        return "animal-list"; // Return the FreeMarker template name ("animal-list.ftlh")
    }
    
    /**
     * Add a new Animal to the database.
     * http://localhost:8080/animals/add
     *
     * @param animal the Animal object to add.
     * @return a new Animal object.
     */
    @PostMapping("/add")
    public Object addAnimal(@RequestBody Animal animal) {
        AnimalService.addAnimal(animal);
        return new ResponseEntity<>(AnimalService.getAllAnimals(), HttpStatus.OK);
    }

    /**
     * Update an existing Animal in the database.
     * http://localhost:8080/animals/update
     *
     * @param animal the Animal object to update.
     * @return an updated Animal object.
     */
    @PutMapping("/update/{animalId}")
    public Object updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        AnimalService.updateAnimal(animal);
        return new ResponseEntity<>(AnimalService.getAllAnimals(), HttpStatus.OK);
    }
 

    /**
     * Delete an existing Animal from the database.
     * http://localhost:8080/animals/delete/1
     *
     * @param animalId the ID of the Animal to delete.
     * @return a list of all Animals in the database.
     */
    @DeleteMapping("/delete/{animalId}")
    public Object deleteAnimal(@PathVariable int animalId) {
        AnimalService.deleteAnimal(animalId);
        return new ResponseEntity<>(AnimalService.getAllAnimals(), HttpStatus.OK);
    }
}
