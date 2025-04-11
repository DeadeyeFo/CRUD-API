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
 * Includes all MVC mappings for the Animal object.
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
    public Object getAnimalById(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", AnimalService.getAnimalById(animalId)); // Add the animal to the model
        model.addAttribute("title", "Animal ID: " + animalId); // Add a title for the page
        return "animal-details"; // Return the FreeMarker template name ("animal-list.ftlh")
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
     * Show the view for a new Animal Form.
     * http://localhost:8080/animals/createForm
     * 
     * @param animal
     * @return the form view
     */
    @GetMapping("/createForm")
    public String showCreateAnimalForm(Model model) {
        Animal animal = new Animal(); // Create a new Animal object
        model.addAttribute("animal", animal); // Add the animal to the model
        model.addAttribute("title", "Create Animal"); // Add a title for the page
        return "animal-create"; // Return the FreeMarker template name ("animal-form.ftlh")
    }
    
    
    /**
     * Add a new Animal to the database.
     * http://localhost:8080/animals/add
     *
     * @param animal the Animal object to add.
     * @return page of updated list of Animals.
     */
    @PostMapping("/add")
    public Object addAnimal(Animal animal) {
        AnimalService.addAnimal(animal);
        // return new ResponseEntity<>(AnimalService.getAllAnimals(), HttpStatus.OK);
        return "redirect:/animals/all"; // Redirect to the list of animals after adding a new one
        
    }

    /**
     * Show the update form for an existing Animal.
     *
     *
     * @param animalId the ID of the Animal to update.
     * @param model the model to add attributes to.
     * @return the update form view.
     */
    @GetMapping("/update/{animalId:[0-9]+}")
    public Object updateAnimal(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", AnimalService.getAnimalById(animalId)); // Add the animal to the model
        model.addAttribute("title", "Update Animal: " + animalId); // Add a title for the page
        return "animal-update";
    }

    /**
     * Update an existing Animal in the database.
     * http://localhost:8080/animals/update/1
     *
     * @param animalId the ID of the Animal to update.
     * @param animal the updated Animal object.
     * @return a list of all Animals in the database.
     */
    @PostMapping("/update/{animalId:[0-9]+}")
    public Object updateAnimal(@PathVariable int animalId, Animal animal) {
        AnimalService.updateAnimal(animalId, animal);
        return "redirect:/animals/all"; // Redirect to the list of animals after updating one
    }
 

    /**
     * Delete an existing Animal from the database.
     * http://localhost:8080/animals/delete/1
     *
     * @param animalId the ID of the Animal to delete.
     * @return a list of all Animals in the database.
     */
    @GetMapping("/delete/{animalId:[0-9]+}")
    public Object deleteAnimal(@PathVariable int animalId) {
        AnimalService.deleteAnimal(animalId);
        return "redirect:/animals/all"; // Redirect to the list of animals after deleting one
    }
}
