public class code {

    public static void main(String[] args) {
        code run = new code();
        System.out.printf(String.valueOf(run.mostCaloriesNum()));
    }

    public int mostCaloriesNum() {
        int totalCalories = 0;
        for(int i=0; i<readInFile().length; i++) {
            if(readInFile()[i]>totalCalories) {
                totalCalories = readInFile()[i];
            }
        }
        return totalCalories;
    }

    public int[] readInFile() {
        int[] caloriesPerElf = new int[1000];
        return caloriesPerElf;
    }
}
