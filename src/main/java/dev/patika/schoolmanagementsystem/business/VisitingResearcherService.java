package dev.patika.schoolmanagementsystem.business;

public interface VisitingResearcherService {

    /**
     * Increases or decreases the salary as a percentage.
     *
     * @param id      the primary key of the entity.
     * @param percent increase/decrease percentage.
     */
    void updateHourlySalary(Long id, double percent);

}
