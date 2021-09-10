package dev.patika.schoolmanagementsystem.api.controllers;

import dev.patika.schoolmanagementsystem.business.PermanentInstructorService;
import dev.patika.schoolmanagementsystem.core.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/instructors/permanent-instructors")
public class PermanentInstructorController {

    private final PermanentInstructorService permanentInstructorService;

    @Autowired
    public PermanentInstructorController(PermanentInstructorService permanentInstructorService) {
        this.permanentInstructorService = permanentInstructorService;
    }

    @PutMapping("/{id}/fixed-salary/{percent}")
    public ResponseEntity<Result> update(@PathVariable long id, @PathVariable double percent) {

        permanentInstructorService.updateFixedSalary(id, percent);
        return ResponseEntity.noContent().build();
    }

}
