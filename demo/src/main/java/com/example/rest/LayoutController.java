package com.example.rest;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.example.domain.Layout;
import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/layout")
public class LayoutController {
    @Autowired
    private SolverManager<Layout, UUID> solverManager;

    @PostMapping("/solve")
    public Layout solve(@RequestBody Layout problem) {
        UUID problemId = UUID.randomUUID();
        // Submit the problem to start solving
        SolverJob<Layout, UUID> solverJob = solverManager.solve(problemId, problem);
        Layout solution;
        try {
            // Wait until the solving ends
            solution = solverJob.getFinalBestSolution();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Solving failed.", e);
        }
        return solution;
    }
}
