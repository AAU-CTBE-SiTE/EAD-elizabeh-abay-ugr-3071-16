package com.example;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ActorController {

    private final ActorRepository actorRepository;

    // Inject the repository via constructor (Spring automatically wires this)
    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    // 1. Get all actors from MySQL
    @GetMapping("/actor")
    public List<Actor> getActors() {
        return actorRepository.findAll();
    }

    // 2. Get a single actor by ID from MySQL
    @GetMapping("/actor/{id}")
    public Actor getActor(@PathVariable int id) {
        Optional<Actor> actor = actorRepository.findById(id);
        return actor.orElse(new Actor(0, "Not Found", 0));
    }

    // 3. Create a new actor and save it to MySQL
    @PostMapping("/actor")
    public Actor createActor(@RequestBody Actor actorInfo) {
        // actorRepository.save handles both insert and update.
        // If id is null/auto-increment, MySQL generates it.
        return actorRepository.save(actorInfo);
    }

    // 4. Delete an actor from MySQL by ID
    @DeleteMapping("/delete/{id}")
    public boolean deleteActor(@PathVariable int id) {
        if (actorRepository.existsById(id)) {
            actorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // 5. Update an actor's name in MySQL
    @PatchMapping("/actor/{id}/name")
    public boolean patchActorName(@PathVariable int id, @RequestBody String name) {
        Optional<Actor> optionalActor = actorRepository.findById(id);
        if (optionalActor.isPresent()) {
            Actor actor = optionalActor.get();
            actor.setName(name);
            actorRepository.save(actor); // Saves changes to the database
            return true;
        }
        return false;
    }

    // 6. Update an actor's age in MySQL
    @PatchMapping("/actor/{id}/age")
    public boolean patchActorAge(@PathVariable int id, @RequestBody Integer newAge) {
        Optional<Actor> optionalActor = actorRepository.findById(id);
        if (optionalActor.isPresent()) {
            Actor actor = optionalActor.get();
            actor.setAge(newAge);
            actorRepository.save(actor);
            return true;
        }
        return false;
    }

    // 7. Full update (PUT) for an actor in MySQL
    @PutMapping("/actor/{id}")
    public boolean putActor(@PathVariable int id, @RequestBody Actor newActorData) {
        Optional<Actor> optionalActor = actorRepository.findById(id);
        if (optionalActor.isPresent()) {
            Actor actor = optionalActor.get();
            actor.setName(newActorData.getName());
            actor.setAge(newActorData.getAge());
            actorRepository.save(actor);
            return true;
        }
        return false;
    }
}