package dev.patika.schoolmanagementsystem.api.controllers;

import dev.patika.schoolmanagementsystem.business.VisitingResearcherService;
import dev.patika.schoolmanagementsystem.core.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/instructors/visiting-researchers")
public class VisitingResearcherController {

    private final VisitingResearcherService visitingResearcherService;

    @Autowired
    public VisitingResearcherController(VisitingResearcherService visitingResearcherService) {
        this.visitingResearcherService = visitingResearcherService;
    }

    @PutMapping("/{id}/hourly-salary/{percent}")
    public ResponseEntity<Result> update(@PathVariable long id, @PathVariable double percent) {

        visitingResearcherService.updateHourlySalary(id, percent);
        return ResponseEntity.noContent().build();
    }

}
