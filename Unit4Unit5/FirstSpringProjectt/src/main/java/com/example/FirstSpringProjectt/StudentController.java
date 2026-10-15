package com.example.FirstSpringProjectt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students") // Base path for all endpoints in this controller
public class StudentController {
        List<Students> users = new ArrayList<>();


    // GET: http://localhost:8080/students/1000
    // Dynamic path variables require curly braces around the variable name: /{id}
    @GetMapping("/{id}")
    public String getUser(@PathVariable long id) {
        return "User " + id;
    }

    // POST: http://localhost:8080/students
    // Creates a new student resource using data from the request body
    @PostMapping
    public String AddUser(@RequestBody Students student) {
        // TODO: Add logic to save the student in a database
        users.add(student);
        return "Added user " + student.getName() + " with ID " + student.getId();
    }

    // PUT: http://localhost:8080/students/1000
    // Updates an existing student specified by the path variable
    @PutMapping("/{id}")
    public Students updateUser(@PathVariable long id) {
        // TODO: Add logic to update the student in a database
        for (Students student : users) {
            if (student.getId() == id) {
                // Update the student details here
                return student;
            }
        }
        return null;
    }
    @GetMapping
    public List<Students> getAllUsers() {
        return users;
    }

    // DELETE: http://localhost:8080/students/1000
    // Deletes a student by ID
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
        return "deleted user " + id;
    }
}