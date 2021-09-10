package dev.patika.schoolmanagementsystem.business.concretes;

import dev.patika.schoolmanagementsystem.business.VisitingResearcherService;
import dev.patika.schoolmanagementsystem.core.exceptions.EntityNotExistsException;
import dev.patika.schoolmanagementsystem.core.utils.BigDecimals;
import dev.patika.schoolmanagementsystem.core.utils.SalaryHelper;
import dev.patika.schoolmanagementsystem.dataaccess.VisitingResearcherRepository;
import dev.patika.schoolmanagementsystem.entities.VisitingResearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class VisitingResearcherManager implements VisitingResearcherService {

    private final VisitingResearcherRepository repository;

    @Autowired
    public VisitingResearcherManager(VisitingResearcherRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public void updateHourlySalary(Long id, double percent) {

        VisitingResearcher visitingResearcher = repository.findById(id)
                // Check if the visitingResearcher is exists
                .orElseThrow(() -> new EntityNotExistsException("VisitingResearcher", Pair.of("id", id)));

        visitingResearcher.setHourlySalary(SalaryHelper.increaseByPercent(visitingResearcher.getHourlySalary(), percent));
        repository.save(visitingResearcher);
    }
}
