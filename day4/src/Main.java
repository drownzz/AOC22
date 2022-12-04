import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Dave Thijs <d.thijs@st.hanze.nl>
 * <p>
 * Wat doet deze klasse?
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("resources/input.txt");
        ArrayList<String> lines = new ArrayList<>();

        try(Scanner fileReader = new Scanner(file);){
            while(fileReader.hasNext()){
                String line = fileReader.nextLine();
                lines.add(line);
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found!");
        }

        int total = 0;

        for(int i = 0; i < lines.size(); i++) {
            String[] splitLine = lines.get(i).split(",");
            if(troep2A(splitLine)){
                total++;
            }
        }
        System.out.println(total);
    }

    public static boolean troep(String[] splitLine){
        for(int j = 0; j < splitLine.length; j+=2) {

            StringBuilder stringBuilder = new StringBuilder();
            int[] range = IntStream.rangeClosed(Integer.parseInt(splitLine[j].substring(0, splitLine[j].indexOf("-"))),
                    Integer.parseInt(splitLine[j].substring(splitLine[j].indexOf("-") + 1))).toArray();
            for (int k = 0; k < range.length; k++) {
                stringBuilder.append("-");
                stringBuilder.append(range[k]);
                stringBuilder.append("-");
            }

            StringBuilder stringBuilder2 = new StringBuilder();
            int[] range2 = IntStream.rangeClosed(Integer.parseInt(splitLine[j + 1].substring(0, splitLine[j + 1].indexOf("-"))),
                    Integer.parseInt(splitLine[j + 1].substring(splitLine[j + 1].indexOf("-") + 1))).toArray();
            for (int l = 0; l < range2.length; l++) {
                stringBuilder2.append("-");
                stringBuilder2.append(range2[l]);
                stringBuilder2.append("-");
            }

            if (stringBuilder.toString().contains(stringBuilder2) || stringBuilder2.toString().contains(stringBuilder)) {
                return true;
            }
        }
        return false;
    }

    public static boolean troep2A(String[] splitLine) {
        for(int j = 0; j < splitLine.length; j+=2){
            int firstNum = Integer.parseInt(splitLine[j].substring(0,splitLine[j].indexOf("-")));
            int secondNum = Integer.parseInt(splitLine[j].substring(splitLine[j].indexOf("-") + 1));
            int thirdNum = Integer.parseInt(splitLine[j + 1].substring(0,splitLine[j + 1].indexOf("-")));
            int fourthNum = Integer.parseInt(splitLine[j + 1].substring(splitLine[j + 1].indexOf("-") + 1));

            if((firstNum <= thirdNum && secondNum >= fourthNum) || (firstNum >= thirdNum && secondNum <= fourthNum)){
                return true;
            }
        }
        return false;
    }

    public static void troep2B(){
        File file = new File("resources/input.txt");
        ArrayList<String> lines = new ArrayList<>();

        try (Scanner fileReader = new Scanner(file);) {
            while (fileReader.hasNext()) {
                String line = fileReader.nextLine();
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        int total = 0;

        for (int i = 0; i < lines.size(); i++) {
            String[] splitLine = lines.get(i).split(",");
            for(int j = 0; j < splitLine.length; j+=2){
                int firstNum = Integer.parseInt(splitLine[j].substring(0,splitLine[j].indexOf("-")));
                int secondNum = Integer.parseInt(splitLine[j].substring(splitLine[j].indexOf("-") + 1));
                int thirdNum = Integer.parseInt(splitLine[j + 1].substring(0,splitLine[j + 1].indexOf("-")));
                int fourthNum = Integer.parseInt(splitLine[j + 1].substring(splitLine[j + 1].indexOf("-") + 1));

                System.out.println(Arrays.toString(splitLine));
                if((firstNum <= thirdNum && secondNum >= thirdNum) || (firstNum >= thirdNum && firstNum <= fourthNum)){
                    System.out.println("OK");
                    total++;
                }else{
                    System.out.println("Fout");
                }
            }
        }
        System.out.println(total);
    }
}
