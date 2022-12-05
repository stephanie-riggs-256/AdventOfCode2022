import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class code {

    public static void main(String[] args) {
        code run = new code();
        System.out.println(run.calculateScore());
    }

    public int calculateScore() {
        int totalScore = 0;
        int winningPoints, choicePoints, roundPoints;
        for(int i=0; i<readFile().size(); i++) {
            winningPoints = calculateWinningPoints(readFile().get(i));
            choicePoints = calculateChoicePoints(readFile().get(i));
            roundPoints = winningPoints + choicePoints;
            totalScore += roundPoints;
        }
        return totalScore;
    }

    public int calculateWinningPoints(String roundStrategy) {
        char opponentChoice = roundStrategy.charAt(0);
        char yourChoice = roundStrategy.charAt(2);
        if (opponentChoice == 'A') {
            if (yourChoice == 'X') {
                return 3;
            } else if (yourChoice == 'Y') {
                return 6;
            } else if (yourChoice == 'Z') {
                return 0;
            }
        } else if (opponentChoice == 'B') {
            if (yourChoice == 'X') {
                return 0;
            } else if (yourChoice == 'Y') {
                return 3;
            } else if (yourChoice == 'Z') {
                return 6;
            }
        } else if (opponentChoice == 'C') {
            if (yourChoice == 'X') {
                return 6;
            } else if (yourChoice == 'Y') {
                return 0;
            } else if (yourChoice == 'Z') {
                return 3;
            }
        }
        return 0;
    }

    public int calculateChoicePoints(String roundStrategy) {
        char choice = roundStrategy.charAt(2);
        if (choice == 'X') {
            return 1;
        } else if (choice == 'Y') {
            return 2;
        } else if (choice == 'Z') {
            return 3;
        }
        return 0;
    }

    public List<String> readFile() {
        List<String> strategyGuide = new ArrayList<>();
        String filePath = "/Users/stephanieriggs/IdeaProjects/AdventOfCode2022/Day2/src/input.txt";
        try {
            FileReader reader = new FileReader(filePath);
            Scanner scanner = new Scanner(reader);
            String str;
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                strategyGuide.add(str);
            }
        } catch (FileNotFoundException e) {
            System.out.print("Error: file not found\n");
        }
        return strategyGuide;
    }
}