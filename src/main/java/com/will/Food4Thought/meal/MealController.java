package com.will.Food4Thought.meal;



import com.will.Food4Thought.person.Person;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class MealController {

    private MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping(path = "meals")
    public List<Meals> getAllMeals(){
        return mealService.selectAllMeals();
    }

    @GetMapping(path = "meals/{id}")
    public Meals getMealsById(@PathVariable ("id") Integer mealId){
        return mealService.selectMealById(mealId);
    }

    @GetMapping(path = "user")
    public Meals getMealsByPerson(@RequestBody Person person){
        return mealService.selectMealByPerson(person);
    }

    @PostMapping(path = "meals")
    public void insertMeal(@RequestBody Meals meals){
         mealService.insertMeal(meals);
    }

    @DeleteMapping(path = "meals/{id}")
    public void deleteMealById(@PathVariable("id") Integer mealId) {
        mealService.deleteMeal(mealId);
    }

    @PutMapping(path = "meals/{id}")
    public void updateById(@PathVariable("id") Integer mealId, @RequestBody Meals update ){
        mealService.updateById(mealId,update);
    }
}
