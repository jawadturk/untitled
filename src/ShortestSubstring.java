import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShortestSubstring {
    final static int NO_OF_CHARS = 256;

    public static void main(String[] args) {

        String str = "ABBCSAASAAAAAB";
        System.out.println(" The length of the shortest substring that contains all distinct characters : "+smallesteSubstr_maxDistictChar(str));
    }

    static int smallesteSubstr_maxDistictChar(String str) {

        // size of given string
        int n = str.length();

        // Find maximum distinct characters in any string
        int maxDistinctCharLength = getDistinctStringChars(str).size();

        // result
        int min = n;

        // Brute force approach to find all substrings
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n ; j++) {

                String subs =  str.substring(i, j);
                System.out.println(subs);
                int subStringLength = subs.length();
                int subStringDistinctCharLength = getDistinctStringChars(subs).size();

                // We have to check here both conditions together
                // 1. substring's distinct characters is equal to maximum distinct characters
                // 2. substing's length should be minimum
                if (subStringLength < min && maxDistinctCharLength == subStringDistinctCharLength) {
                    min = subStringLength;
                }
            }
        }

        return min;
    }

    private static List<String> getDistinctStringChars(String word){
        List<String> collect = Stream.of(word)
                .map(st -> st.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
//        System.out.println(collect.toString());
        return collect;
    }
}
