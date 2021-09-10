package dev.patika.schoolmanagementsystem.api.controllers;

import dev.patika.schoolmanagementsystem.core.results.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/instructors/permanent-instructors")
public class PermanentInstructorController {

    @PutMapping("/{id}/fixed-salary/{percent}")
    public ResponseEntity<Result> update(@PathVariable long id, @PathVariable double percent) {

        return ResponseEntity.noContent().build();
    }

}
