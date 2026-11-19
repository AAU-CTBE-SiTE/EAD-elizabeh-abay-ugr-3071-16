package com.example;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private final StudentRepostiory studentRepostiory;

    // Inject the repository via constructor (Spring automatically wires this)
    public StudentController(StudentRepostiory studentRepostiory) {
        this.studentRepostiory = studentRepostiory;
    }

    // 1. Get all actors from MySQL
    @GetMapping("/students")
    public List<StudentDTO> getActors() {
        List<Student> students = studentRepostiory.findAll();
        // to change this list of student to dto

        List<StudentDTO> studentDTOs = new ArrayList<>();

        for (Student student : students) {
            studentDTOs.add(DtoMapper.toStudentDTO(student));
        }

        return studentDTOs;
    }

    // 2. Get a single actor by ID from MySQL
    @GetMapping("/students/{id}")
    public StudentDTO getActor(@PathVariable int id) {
        Optional<Student> student = studentRepostiory.findById(id);
        if (student.isPresent()) {
            Student studentT = student.get();
            // work with student
            return DtoMapper.toStudentDTO(studentT);
        }
        return new StudentDTO(); // Return an empty DTO if not found
    }

    // 3. Create a new actor and save it to MySQL
    @PostMapping("/students")
    public StudentDTO createActor(@RequestBody Student actorInfo) {
        // StudentRepostiory.save handles both insert and update.
        // If id is null/auto-increment, MySQL generates it.
        Student student = studentRepostiory.save(actorInfo);

        return DtoMapper.toStudentDTO(student);
    }

    // 4. Delete an actor from MySQL by ID
    @DeleteMapping("/students/{id}")
    public boolean deleteActor(@PathVariable int id) {
        if (studentRepostiory.existsById(id)) {
            studentRepostiory.deleteById(id);
            return true;
        }
        return false;
    }

    // 5. Update an actor's name in MySQL
    @PatchMapping("/students/{id}/first-name")
    public boolean patchActorName(@PathVariable int id, @RequestBody String name) {
        Optional<Student> optionalActor = studentRepostiory.findById(id);
        if (optionalActor.isPresent()) {
            Student student = optionalActor.get();
            student.setFirstName(name);
            studentRepostiory.save(student); // Saves changes to the database
            return true;
        }
        return false;
    }

    // 6. Update an actor's age in MySQL
    @PatchMapping("/students/{id}/last-name")
    public boolean patchActorAge(@PathVariable int id, @RequestBody String newLastName) {
        Optional<Student> optionalActor = studentRepostiory.findById(id);
        if (optionalActor.isPresent()) {
            Student student = optionalActor.get();
            student.setLastName(newLastName);
            studentRepostiory.save(student);
            return true;
        }
        return false;
    }

    // 7. Full update (PUT) for an actor in MySQL
    @PutMapping("/students/{id}")
    public boolean putActor(@PathVariable int id, @RequestBody Student newActorData) {
        Optional<Student> optionalActor = studentRepostiory.findById(id);
        if (optionalActor.isPresent()) {
            Student actor = optionalActor.get();
            actor.setFirstName(newActorData.getFirstName());
            actor.setLastName(newActorData.getLastName());
            actor.setEmail(newActorData.getEmail());
            actor.setDepartment(newActorData.getDepartement());

            studentRepostiory.save(actor);
            return true;
        }
        return false;
    }
}