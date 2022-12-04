import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class code {

    public static void main(String[] args) {
        code run = new code();
//        System.out.printf(String.valueOf(run.mostCaloriesCalculation()));
        System.out.printf(String.valueOf(run.topThreeMostCaloriesCalculation()));
    }

    public int mostCaloriesCalculation() {
        int totalCalories = 0;
        for(int i=0; i<countCaloriesPerElf().size(); i++) {
            if(countCaloriesPerElf().get(i)>totalCalories) {
                totalCalories = countCaloriesPerElf().get(i);
            }
        }
        return totalCalories;
    }

    public int topThreeMostCaloriesCalculation() {
        int firstMostCalories = 0;
        int secondMostCalories = 0;
        int thirdMostCalories = 0;
        for(int i=0; i<countCaloriesPerElf().size(); i++) {
            if(countCaloriesPerElf().get(i)>firstMostCalories) {
                thirdMostCalories = secondMostCalories;
                secondMostCalories = firstMostCalories;
                firstMostCalories = countCaloriesPerElf().get(i);
            } else if(countCaloriesPerElf().get(i)>secondMostCalories) {
                thirdMostCalories = secondMostCalories;
                secondMostCalories = countCaloriesPerElf().get(i);
            } else if(countCaloriesPerElf().get(i)>thirdMostCalories) {
                thirdMostCalories = countCaloriesPerElf().get(i);
            }
        }
        return firstMostCalories + secondMostCalories + thirdMostCalories;
    }

    public List<String> convertFileToArrayList() {
        List<String> caloriesList = new ArrayList<>();
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
            System.out.print("Error: file not found\n");
        }
        return caloriesList;
    }

    public List<Integer> countCaloriesPerElf() {
        List<String> calorieInformation = convertFileToArrayList();
        List<Integer> caloriesPerElf = new ArrayList<>();
        int currentTotal = 0;
        for (String s : calorieInformation) {
            if (s.equals("")) {
                caloriesPerElf.add(currentTotal);
                currentTotal = 0;
            } else {
                currentTotal += Integer.parseInt(s);
            }
        }
        caloriesPerElf.add(currentTotal);
        return caloriesPerElf;
    }
}
