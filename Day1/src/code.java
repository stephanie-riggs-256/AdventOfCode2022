import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class code {

    public static void main(String[] args) {
        code run = new code();
        System.out.printf(String.valueOf(run.mostCaloriesCalculation()));
    }

    public int mostCaloriesCalculation() {
        int totalCalories = 0;
        for(int i = 0; i < countCaloriesPerElf().size(); i++) {
            if(countCaloriesPerElf().get(i)>totalCalories) {
                totalCalories = countCaloriesPerElf().get(i);
            }
        }
        return totalCalories;
    }

    public List<String> convertFileToArrayList() {
        List<String> caloriesList = new ArrayList<String>();
        String filePath = "/Users/stephanieriggs/IdeaProjects/AdventOfCode2022/Day1/src/input.txt";
        try {
            FileReader calorieInformation = new FileReader(filePath);
            Scanner scanner = new Scanner(calorieInformation);
            String str;
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                caloriesList.add(str);
            }
        } catch (FileNotFoundException e) {
            System.out.printf("Error: file not found\n");
        }
        return caloriesList;
    }

    public List<Integer> countCaloriesPerElf() {
        List<String> calorieInformation = convertFileToArrayList();
        List<Integer> caloriesPerElf = new ArrayList<Integer>();
        Integer currentTotal = 0;
        for(int i=0; i<calorieInformation.size(); i++) {
            if(calorieInformation.get(i)=="") {
                caloriesPerElf.add(currentTotal);
                currentTotal = 0;
            } else {
                currentTotal += Integer.valueOf(calorieInformation.get(i));
            }
        }
        caloriesPerElf.add(currentTotal);
        return caloriesPerElf;
    }
}
