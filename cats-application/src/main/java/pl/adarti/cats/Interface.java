package pl.adarti.cats;

import pl.adarti.cats.domain.Cat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Application interface - a class that can be run thanks to main(...)
 */
public class Interface {

    /**
     * a Scanner object for loading input from the kayboard
     */
    private static Scanner scanner = new Scanner(System.in);
    private static CatsDAO catsDAO = new CatsDAO();
    private static List<Cat> catsList = catsDAO.getCatsList();

    /**
     * the main method that allows you to run the class as an application
     *
     * @param args console arguments - unused
     */
    public static void main(String[] args) {
        String chosenOption;
        do {
            showMenu();
            chosenOption = getUserInput();
            switch (chosenOption) {
                case "1":
                    makeCat();
                    break;
                case "2":
                    if (catsList.size() == 0)
                        System.out.println("the cats list is empty");
                    else
                        showCatsList();
                    break;
                case "x":
                    System.out.println("application exit...");
                    break;
                default:
                    System.out.println("application doesn't recognize that command");
                    break;
            }
        } while (!chosenOption.equalsIgnoreCase("x"));
    }


    private static void showCatsList() {
        System.out.println("***************************************************");
        System.out.println("*****            Cats list                   ******");
        System.out.println("***************************************************\n");
        Cat cat;
        for (int i = 0; i < catsList.size(); i++) {
            cat = catsList.get(i);
            System.out.println(i + 1 + ": " + cat.getName());
        }

        Pattern pattern = Pattern.compile("[1-9][0-9]*");
        String chosenIndex;
        do {
            System.out.println("enter the index to let the cat introduce itself");
            chosenIndex = getUserInput();
        } while (!pattern.matcher(chosenIndex).matches());

        int catIndex = Integer.parseInt(chosenIndex) - 1;
        Cat chosenCat;
        if (catIndex < catsList.size()) {
            chosenCat = catsList.get(catIndex);
            System.out.println(chosenCat.introduceYourself());
        } else
            System.out.println("chosen cat doesn't exist\n" +
                    "choose another one or add a cat");
    }

    private static void showMenu() {
        System.out.println("\n***************************************************");
        System.out.println("*****            Application menu             *****");
        System.out.println("***************************************************");
        System.out.print("[1] make cat\n" +
                "[2] show all cats\n" +
                "[x] exit\n");
        System.out.println("type menu option and click enter to continue");
    }

    /**
     * auxiary method allows to get one line typed by the user
     *
     * @return loaded line
     */
    private static String getUserInput() {
        return scanner.nextLine().trim();
    }

    /**
     * set and add to db cat data
     */
    private static void makeCat() {
        Cat cat = new Cat();
        System.out.println("Enter cat name");
        cat.setName(getUserInput());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        Pattern birthDayPattern = Pattern.compile("\\d{4}\\.[0-1]\\d\\.[0-3]\\d");
        String inputDate;
        do {
            System.out.println("Enter cat birth day in format YYYY.MM.DD");
            inputDate = getUserInput();
            if (birthDayPattern.matcher(inputDate).matches()) {
                try {
                    cat.setBirthDate(sdf.parse(inputDate));
                } catch (ParseException e) {
                    System.out.println("something wrong with the input date");
                }
            }
        } while (cat.getBirthDate() == null);

        Pattern weightPattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        String inputWeight;
        do {
            System.out.println("enter the cat weight");
            inputWeight = getUserInput();
            if (weightPattern.matcher(inputWeight).matches()) {
                try {
                    cat.setWeight(Float.valueOf(inputWeight));
                } catch (NumberFormatException nse) {
                    System.out.println("something wrong with the input weight");
                }
            }
        } while (cat.getWeight() == 0);

        System.out.println("enter the keeper name");
        cat.setKeeper(getUserInput());

        System.out.println("thanks, that's all information about a cat");

        catsDAO.addCat(cat);
    }
}
