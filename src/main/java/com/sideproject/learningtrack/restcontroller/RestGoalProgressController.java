package com.sideproject.learningtrack.restcontroller;

import com.sideproject.learningtrack.domain.Goal;
import com.sideproject.learningtrack.domain.GoalProgress;
import com.sideproject.learningtrack.repository.GoalProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestGoalProgressController {

    @Autowired
    private GoalProgressRepository goalProgressRepository;

    @GetMapping(value = "/all-progresses", produces = "application/json")
    public List<GoalProgress> getAllProgresses() {
        return goalProgressRepository.findAll();
    }

    @GetMapping(value = "/progress/{name}")
    public List<GoalProgress> getProgressesOfOneGoal(@PathVariable String name) {
        return goalProgressRepository.findAllByName(name);
    }

    @PostMapping(value = "/add-progress", consumes = "application/json")
    public GoalProgress addGoalProgress(@RequestBody GoalProgress goalProgress) {
        return goalProgressRepository.insert(goalProgress);
    }

    //todo: currently throwing error when request body not defined
    @DeleteMapping(value = "/delete-progress/{id}")
    public void deleteGoalProgress(@PathVariable GoalProgress id) {
        goalProgressRepository.delete(id);
    }
}
