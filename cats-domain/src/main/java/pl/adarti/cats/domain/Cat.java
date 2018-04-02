package pl.adarti.cats.domain;

import java.text.DateFormat;
import java.util.Date;

public class Cat {
    private String name;
    private String keeper = "Adarti";
    private Date birthDate;
    private float weight;



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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String introduceYourself() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);

        return "My name is " + name + ".\n" +
                "I weight " + weight + " kg. " + "My keeper is Adarti.\n" +
                "I was born in " + df.format(birthDate)+"\n";
    }
}
