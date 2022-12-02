import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Dave Thijs <d.thijs@st.hanze.nl>
 * <p>
 *
 */
public class Main {

    public static int points;

    public static void main(String[] args) {
        File file = new File("resources/input.txt");


        try(Scanner keyboard = new Scanner(file);){
            while(keyboard.hasNext()){
                String line = keyboard.nextLine();
                checkPointsB(line.charAt(0), line.charAt(2));
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        System.out.println(points);
    }

    public static void checkPointsA(char enemy, char player){
        switch(enemy){
            case 'A':
                if(player == 'X'){
                    points += 1;
                    points += 3;
                }else if(player == 'Y'){
                    points += 2;
                    points += 6;
                }else if (player == 'Z'){
                    points += 3;
                }
                break;
            case 'B':
                if(player == 'X'){
                    points += 1;
                }else if(player == 'Y'){
                    points += 2;
                    points += 3;
                }else if(player == 'Z'){
                    points += 3;
                    points += 6;
                }
                break;
            case 'C':
                if(player == 'X'){
                    points += 1;
                    points += 6;
                }else if(player == 'Y'){
                    points += 2;
                }else if(player == 'Z'){
                    points += 3;
                    points += 3;
                }
                break;
        }
    }

    public static void checkPointsB(char enemy, char outcome){
        switch(outcome){
            case 'X':
                if(enemy == 'A'){
                    points += 3;
                }else if(enemy == 'B'){
                    points += 1;
                }else if (enemy == 'C'){
                    points += 2;
                }
                break;
            case 'Y':
                points += 3;
                if(enemy == 'A'){
                    points += 1;
                }else if(enemy == 'B'){
                    points += 2;
                }else if (enemy == 'C'){
                    points += 3;
                }
                break;
            case 'Z':
                points += 6;
                if(enemy == 'A'){
                    points += 2;
                }else if(enemy == 'B'){
                    points += 3;
                }else if (enemy == 'C'){
                    points += 1;
                }
                break;
        }
    }
}
