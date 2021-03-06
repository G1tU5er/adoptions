package com.p5.adoptions.api.controllers;

import com.p5.adoptions.model.AnimalDTO;
import com.p5.adoptions.repository.AnimalStore;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/animals")
@PreAuthorize("isAuthorised()")
public class AnimalController {
    //old way - no good! @RequestMapping(method = RequestMethod.GET, value = "/Hello")
    //call: api/v1/animals/Hello

    @GetMapping("/Hello")
    @PreAuthorize("permitAll()")
    public ResponseEntity<String> greetOwner(@RequestParam(name = "name", required = false) String ownerName) {
        String name = ownerName == null ? "world" : ownerName;

        return ResponseEntity.ok("Hello  " + name + ", world, from the animal shelter");
    }

    @GetMapping()
    public ResponseEntity<List<AnimalDTO>> getAvailableAnimals() {
        return ResponseEntity.ok(AnimalStore.available);

    }

    @PostMapping
    public ResponseEntity<AnimalDTO> addAnimalForAdoption(@RequestBody AnimalDTO animal) {
        if (animal == null && animal.getName() == null && animal.getPhotoUrl() == null) {
            return ResponseEntity.badRequest().body(animal);
        }
        AnimalStore.available.add(animal);
        return ResponseEntity.ok(animal);
    }

    @PutMapping("/{name}")
    public void updateAnimal(@PathVariable(name = "name") String name, @RequestBody AnimalDTO updateAnimal){

        List<AnimalDTO>available = AnimalStore.available;

        for (int i=0; i<available.size(); i++){

            AnimalDTO animal = available.get(i);
            if (animal.getName().equals("name")){
                available.remove(i);
                available.add(updateAnimal);
                break;
            }
        }
    }
    @DeleteMapping({"/name"})
    public void deleteAnimal(@PathVariable(name = "name") String name){
  
        List<AnimalDTO>available = AnimalStore.available;
        for (int i=0; i<available.size(); i++){

            AnimalDTO animal = available.get(i);
            if (animal.getName().equals("name")){
                available.remove(i);
                break;
            }
        }

    }
}


