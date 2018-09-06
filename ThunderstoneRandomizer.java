//Samuel Birus
//Randomizer for Thunderstone

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ThunderstoneRandomizer {

    private static final List<String> monsters = new LinkedList<String>();
    private static final List<String> heros = new LinkedList<String>();
    private static final List<String> village = new LinkedList<String>();

    public static void main(String[] args) throws FileNotFoundException {
        addMonsters("monsters.txt");
        addVillagers("village.txt");
        addHeros("heros.txt");

        System.out.println("\nWelcome to Thunderstone!!");
        System.out.println("Here are the cards you will need for this random setup.");

        //determine monsters
        System.out.println("\nMonsters:			Set:");
        List<String> usedMonsters = pickNRandom(monsters, 3);
        for (String monster : usedMonsters) {
            System.out.println("\t" + monster);
        }

        //determine heros
        System.out.println("\nHeros:				Set:");
        List<String> usedHeros = pickNRandom(heros, 4);
        for (String hero : usedHeros) {
            System.out.println("\t" + hero);
        }

        //determine villagers
        System.out.println("\nVillagers:			Set:");
        List<String> usedVillagers = pickNRandom(village, 8);
        for (String villager : usedVillagers) {
            System.out.println("\t" + villager);
        }

    }

    public static List<String> pickNRandom(List<String> lst, int n) {
        List<String> copy = new LinkedList<String>(lst);
        Collections.shuffle(copy);
        return copy.subList(0, n);
    }

    //add monsters to the list
    private static void addMonsters(String mon) throws FileNotFoundException {
        Scanner reader1 = new Scanner(new File(mon));

        while (reader1.hasNextLine()) {
            monsters.add(reader1.nextLine());
        }

        reader1.close();
    }

    //add villagers to the list
    private static void addVillagers(String vil) throws FileNotFoundException {
        Scanner reader2 = new Scanner(new File(vil));

        while (reader2.hasNextLine()) {
            village.add(reader2.nextLine());
        }

        reader2.close();
    }

    //add heros to the list
    private static void addHeros(String hero) throws FileNotFoundException {
        Scanner reader3 = new Scanner(new File(hero));

        while (reader3.hasNextLine()) {
            heros.add(reader3.nextLine());
        }

        reader3.close();
    }
}
