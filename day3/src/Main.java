import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Dave Thijs <d.thijs@st.hanze.nl>
 * <p>
 * Wat doet deze klasse?
 */
public class Main {
    final static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) {
        day3B();
    }

    public static void day3A(){
        File file = new File("resources/input.txt");
        ArrayList<Character> characters = new ArrayList<>();
        int points = 0;

        try(Scanner fileReader = new Scanner(file);){
            while(fileReader.hasNext()){
                String line = fileReader.nextLine();
                String compartment1 = line.substring(0, line.length()/2);
                String compartment2 = line.substring(line.length()/2);
                System.out.println(compartment1);
                System.out.println(compartment2);
                characters.add(findMatch(compartment1, compartment2));
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found!");
        }

        for(char character : characters){
            points += alphabet.indexOf(character) + 1;
        }

        System.out.println(points);
    }

    public static char findMatch(String compartment1, String compartment2){
        for(int i = 0; i < compartment1.length(); i++){
            if(compartment2.indexOf(compartment1.charAt(i)) != -1){
                return compartment1.charAt(i);
            }
        }
        return 0;
    }

    public static void day3B(){
        File file = new File("resources/input.txt");
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Character> characters = new ArrayList<>();
        int points = 0;

        try(Scanner fileReader = new Scanner(file);){
            while(fileReader.hasNext()){
                String line = fileReader.nextLine();
                lines.add(line);
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found!");
        }

        for(int i = 0; i < lines.size(); i+=3){
            characters.add(findMatchB(lines.get(i), lines.get(i + 1),lines.get(i + 2) ));
        }
        for(char character : characters){
            points += alphabet.indexOf(character) + 1;
        }
        System.out.println(points);
    }

    public static char findMatchB(String rucksack1, String rucksack2, String rucksack3){
        for (int i = 0; i < rucksack1.length(); i++) {
            if (rucksack2.indexOf(rucksack1.charAt(i)) != -1) {
                if (rucksack3.indexOf(rucksack1.charAt(i)) != -1) {
                    return rucksack1.charAt(i);
                }
            }
        }
        return 0;
    }
}
