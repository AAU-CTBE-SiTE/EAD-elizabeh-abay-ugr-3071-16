package com.example;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ActorController {
    List<Actor> actors = new ArrayList<>();

    // when it starts first it creates the things
    public ActorController() {
        actors.add(new Actor(1, "Angelina Joulie", 42));
        actors.add(new Actor(2, "Will Smith", 41));
        actors.add(new Actor(3, "Jeniffer Aniston", 52));
        actors.add(new Actor(4, "Anna Hathaway", 48));
    }

    // browser always sends a get request
    @GetMapping("/actor")
    public List<Actor> GetActors() {
        return actors;
    }

    @GetMapping("/actor/{id}")
    public Actor getActor(@PathVariable int id) {
        for (Actor actor : actors) {
            if (actor.getId() == id)
                return actor;
        }

        return new Actor(0, " ", 0);
    }

    @PostMapping("/actor")
    public boolean createActor(@RequestBody Actor actorInfo) {
        try {
            // System.out.println("Here is the thing sent");
            // System.out.println(actorInfo.getName());
            // System.out.println(actorInfo.getAge());
            actors.add(actorInfo);
            return true;
        } catch (Exception e) {
            System.out.println("Error happened " + e);
            return false;

        }

    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteActor(@PathVariable int id) {
        boolean removedActor = actors.removeIf(
                actor -> actor.getId() == id);

        return removedActor;
    }

    @PatchMapping("/actor/{id}/name")
    public boolean patchActorName(@PathVariable int id, @RequestBody String Name) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                System.out.println("Name sent from the postman " + Name);
                actor.setName(Name);
                return true;
            }
        }

        return false;
    }

    @PatchMapping("/actor/{id}/age")
    public boolean patchActorAge(@PathVariable int id, @RequestBody Integer newAge) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                actor.setAge(newAge);
                return true;
            }
        }

        return false;
    }

    @PutMapping("/actor/{id}")
    public boolean putActor(@PathVariable int id, @RequestBody Actor newActor) {
        // id can't be reset
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                actor.setAge(newActor.getAge());
                actor.setName(newActor.getName());
                return true;
            }
        }

        return false;

    }
}
