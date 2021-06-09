package com.example.rest;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.Position;
import com.example.domain.Product;
import com.example.domain.Location;
import com.example.domain.Layout;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(properties = {
    "optaplanner.solver.termination.spent-limit=1h", // Effectively disable this termination in favor of the best-score-limit
    "optaplanner.solver.termination.best-score-limit=0hard/*soft"})
public class LayoutControllerTest {
    @Autowired
    private LayoutController layoutController;
    @Test
    @Timeout(600_000)
    public void solve() {
        Layout problem = generateProblem();
        LayoutController controller = new LayoutController();
        Layout solution = controller.solve(problem);
        assertFalse(solution.getPosition().isEmpty());
        for  (Location location : solution.getLocation()) {
            assertNotNull(location.getPos());
            assertNotNull(location.getProd());
        }
        assertTrue(solution.getScore().isFeasible());
    }

    private Layout generateProblem() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(0000,1,10,1));
        productList.add(new Product(0001,2,10,2));
        productList.add(new Product(0002,1,10,2));
        productList.add(new Product(0003,5,10,2));
        productList.add(new Product(0004,6,10,2));
        productList.add(new Product(0005,2,10,2));
        productList.add(new Product(0006,6,10,2));
        productList.add(new Product(0007,3,10,2));

        List<Position> positionList = new ArrayList<>();
        positionList.add(new Position("AAAAAA",0));
        positionList.add(new Position("AAAABB",0));
        positionList.add(new Position("AAAACC",0));
        positionList.add(new Position("AABBAA",0));
        positionList.add(new Position("AABBBB",0));
        positionList.add(new Position("AABBCC",0));
        positionList.add(new Position("AACCAA",0));

        List<Location> locationList = new ArrayList<>();
        locationList.add(new Location(1));
        locationList.add(new Location(2));
        locationList.add(new Location(3));
        locationList.add(new Location(4));
        locationList.add(new Location(5));
        locationList.add(new Location(6));
        locationList.add(new Location(7));
        
        return new Layout(productList, positionList, locationList);
    }
}
