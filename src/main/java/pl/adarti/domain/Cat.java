package pl.adarti.domain;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class Cat {
    private String name;
    private String keeper = "Adarti";
    private LocalDate birthDate = LocalDate.of(2014, Calendar.MARCH, 20);
    private double weight = 5.75;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeeper() {
        return keeper;
    }

    public void setKeeper(String keeper) {
        this.keeper = keeper;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String introduceYourself() {
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        return "My name is " + name + ". I'm " + age + " years old.\n" +
                "I weight " + weight + " kg. " + "My keeper is Adarti.\n" +
                "I was born in date" + birthDate;
    }
}
