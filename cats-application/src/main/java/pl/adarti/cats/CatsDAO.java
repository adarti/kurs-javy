package pl.adarti.cats;

import pl.adarti.cats.domain.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatsDAO {
    private List<Cat> catsList;

    public CatsDAO(){
        this.catsList = new ArrayList<>();
    }

    public List<Cat> getCatsList() {
        return catsList;
    }

    public void addCat(Cat cat){
        catsList.add(cat);
        System.out.println("cat was added successfully\n");
    }
}
