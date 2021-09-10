package dev.patika.schoolmanagementsystem.business.concretes;

import dev.patika.schoolmanagementsystem.business.PermanentInstructorService;
import dev.patika.schoolmanagementsystem.core.exceptions.EntityNotExistsException;
import dev.patika.schoolmanagementsystem.core.utils.BigDecimals;
import dev.patika.schoolmanagementsystem.core.utils.SalaryHelper;
import dev.patika.schoolmanagementsystem.dataaccess.PermanentInstructorRepository;
import dev.patika.schoolmanagementsystem.entities.PermanentInstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class PermanentInstructorManager implements PermanentInstructorService {

    private final PermanentInstructorRepository repository;

    @Autowired
    public PermanentInstructorManager(PermanentInstructorRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public void updateFixedSalary(Long id, double percent) {
        PermanentInstructor permanentInstructor = repository.findById(id)
                // Check if the visitingResearcher is exists
                .orElseThrow(() -> new EntityNotExistsException("PermanentInstructor", Pair.of("id", id)));

        permanentInstructor.setFixedSalary(SalaryHelper.increaseByPercent(permanentInstructor.getFixedSalary(), percent));
        repository.save(permanentInstructor);
    }

}
