package com.example.solver;

import com.example.domain.Location;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;


public class ProductLocationConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
                // Hard constraints
                locationConflict(constraintFactory), overlapConflict(constraintFactory),

                // Soft constraints are only implemented in the "complete" implementation
        };
    }

    private Constraint locationConflict(ConstraintFactory constraintFactory) {
        // A location can hold at most one kind of product at the same time

        // Select a location
        return constraintFactory.from(Location.class)
                // ... and pair it with another location ...
                .join(Location.class, Joiners.equal(Location::getPos), 
                    // in the same position
                    Joiners.equal(Location::getProd),
                    // and the pair is unique (different id, no reverse pairs)
                    Joiners.lessThan(Location::getIdLocation))
                // then penalize each pair with a hard weight.
                .penalize("Location conflict", HardSoftScore.ONE_HARD);
    }

    private Constraint overlapConflict(ConstraintFactory constraintFactory) {
        // A product must

        //return constraintFactory.from();
        return null;
    }
}
