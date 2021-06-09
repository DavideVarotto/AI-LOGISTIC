//Planning solution

package com.example.domain;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution // So OptaPlanner knows that this class contains all of the input and output data 
public class Layout {
    @ValueRangeProvider(id = "prodRange")
    @ProblemFactCollectionProperty
    private List<Product> products;

    @ValueRangeProvider(id = "posRange")
    @ProblemFactCollectionProperty
    private List<Position> positions;

    @PlanningEntityCollectionProperty
    private List<Location> locationList;

    @PlanningScore
    private HardSoftScore score;

    private Layout() {
   }

   public Layout(List<Product> _products, List<Position> _positions, List<Location> _locationList) {
       this.products = _products;
       this.positions = _positions;
       this.locationList = _locationList;
   }

    // ********************************
    // Getters and setters
    // ********************************

    public List<Product> getProducts() {
        return products;
    }

    public List<Position> getPosition() {
        return positions;
    }

    public List<Location> getLocation() {
        return locationList;
    }

    public HardSoftScore getScore() {
        return score;
    }
}
