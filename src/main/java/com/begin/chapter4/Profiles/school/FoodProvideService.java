package com.begin.chapter4.Profiles.school;

import com.begin.chapter4.Profiles.Food;
import com.begin.chapter4.Profiles.FoodProviderService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class FoodProvideService implements FoodProviderService {
    @Override
    public List<Food> provideLunchSet() {
        List<Food> foods = new ArrayList<>();
        foods.add(new Food("Coca-cola"));
        foods.add(new Food("Cackes"));
        foods.add(new Food("Free-potato"));
        return foods;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("school-profile.xml");

        FoodProvideService foodProvider = context.getBean("footProviderService", FoodProvideService.class);
        List<Food> lunchSet = foodProvider.provideLunchSet();

        lunchSet.stream().forEach(val -> System.out.println(val.getName()));

    }
}
