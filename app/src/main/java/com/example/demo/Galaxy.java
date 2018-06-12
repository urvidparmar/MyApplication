package com.example.demo;

/**
 * Created by Oclemy on 2017 for ProgrammingWizards TV Channel and http://www.camposha.info.
 * - Our data object
 * - We pass it data via constructor.
 * - We retrieve its data via getters.
 */

public class Galaxy {

    private String name;
    private Category category;


    public Galaxy(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getCategoryId() {
        return category.getId();
    }

    public String getCategoryName() {
        return category.getName();
    }
}
