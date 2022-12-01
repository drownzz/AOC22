package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Dave Thijs <d.thijs@st.hanze.nl>
 * <p>
 * Wat doet deze klasse?
 */
public class main {
    public static void main(String[] args) {
        day1A();

    }

    public static void day1A(){
        int maxCalories = 0;
        int calories = 0;

        File file = new File("resources/input.txt");
        try(Scanner keyboard = new Scanner(file);) {
            while(keyboard.hasNextLine()){
                String line = keyboard.nextLine();
                if(!line.isBlank()){
                    calories += Integer.parseInt(line);
                }else{
                    if(maxCalories < calories){
                        maxCalories = calories;
                    }
                    calories = 0;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(maxCalories);
    }

    public static void day1B(){
        ArrayList<Integer> caloriesPerElf = new ArrayList<>();
        int maxCalories = 0;
        int calories = 0;

        File file = new File("resources/input.txt");
        try(Scanner keyboard = new Scanner(file);) {
            while(keyboard.hasNextLine()){
                String line = keyboard.nextLine();
                if(!line.isBlank()){
                    calories += Integer.parseInt(line);
                }else{
                    caloriesPerElf.add(calories);
                    calories = 0;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(caloriesPerElf);
        Collections.reverse(caloriesPerElf);
        int totalTopThree = 0;
        for (int i = 0; i < 3; i++) {
            totalTopThree += caloriesPerElf.get(i);
        }

        System.out.println(totalTopThree);
    }
}
