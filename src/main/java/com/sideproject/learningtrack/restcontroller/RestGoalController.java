package com.sideproject.learningtrack.restcontroller;

import com.sideproject.learningtrack.domain.Goal;
import com.sideproject.learningtrack.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestGoalController {

    @Autowired
    private GoalRepository goalRepository;

    @GetMapping(value = "/all-goals", produces = "application/json")
    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    @PostMapping(value = "/add-goal", consumes = "application/json")
    public Goal addNewGoal(@RequestBody Goal goal) {
        return goalRepository.insert(goal);
        //todo: need to handle duplicate and throw exception
    }

//    @DeleteMapping(value = "/delete-goal/{goalId}")
//    public void deleteGoal(@PathVariable Goal goalId) {
//        goalRepository.delete(goalId);
//    }

    //todo: switch back to delete using id when front-end is done
    @DeleteMapping(value = "/delete-goal/{name}")
    public void deleteGoal(@PathVariable String name) {
        goalRepository.deleteByName(name);
    }
}
