package pl.adarti.domain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //read from screen
        Scanner scanner = new Scanner(System.in);

        System.out.println("write a cat name");
        String catName = scanner.nextLine();
        Cat cat = new Cat(catName);
        System.out.println(cat.introduceYourself());
    }
}
