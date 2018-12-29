package com.begin.chapter4.Profiles.kiddengarten;

import com.begin.chapter4.Profiles.Food;
import com.begin.chapter4.Profiles.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

public class FoodProdiveService implements FoodProviderService {
    @Override
    public List<Food> provideLunchSet() {
        List<Food> foods = new ArrayList<>();
        foods.add(new Food("Milk"));
        foods.add(new Food("Buscuit"));
        return foods;
    }
}
