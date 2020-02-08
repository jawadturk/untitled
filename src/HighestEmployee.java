import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class HighestEmployee {
    static int[] employeesRanking = new int[]{10, 20, 10, 15};
    static int teamSize = 3;
    static int numberOfElements = 3;
    static int teamSizeAchieved = 1;
    static int sumOfSelectedEmployeeScores = 0;

    public static void main(String[] args) {


        while (teamSizeAchieved <= teamSize) {
            int arrayLength = employeesRanking.length;
            System.out.println("Contents : " + Arrays.toString(employeesRanking));


            if (employeesRanking.length <= numberOfElements) {


                int n = 0, max = 0;
                for (int i = 0; i < employeesRanking.length; i++) {
                    if (max < employeesRanking[i]) {
                        max = employeesRanking[i];
                        n = i;
                    }
                }

                sumOfSelectedEmployeeScores = sumOfSelectedEmployeeScores + max;
                employeesRanking = removeElementFromArray(employeesRanking, n);

            } else {

                int n = 0, max = 0;
                for (int i = 0; i < arrayLength; i++) {

                    if (i < numberOfElements || i >= arrayLength - numberOfElements) {

                        if (max < employeesRanking[i]) {
                            max = employeesRanking[i];
                            n = i;
                        }
                    }
                }
                sumOfSelectedEmployeeScores = sumOfSelectedEmployeeScores + max;
                employeesRanking = removeElementFromArray(employeesRanking, n);
            }
            teamSizeAchieved = teamSizeAchieved + 1;
        }

        System.out.println("Highest Score " + sumOfSelectedEmployeeScores);
    }

    private static int[] removeElementFromArray(int[] employeesRanking, int removeIndex) {

        if (employeesRanking == null || removeIndex < 0 || removeIndex > employeesRanking.length) {
            return employeesRanking;
        }

        return IntStream.range(0, employeesRanking.length)
                .filter(i -> i != removeIndex)
                .map(i -> employeesRanking[i])
                .toArray();
    }

}
