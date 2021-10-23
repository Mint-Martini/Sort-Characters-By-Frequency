
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String frequencySort(String s) {
        //Declare a Hashmap that will be used to keep track of letter and count
        HashMap<Character,Integer> mainCounter = new HashMap <Character,Integer>();

        for (int i = 0; i < s.length(); i++){
           char c = s.charAt(i);
           boolean letterMappingFlag = mainCounter.containsKey(c);
            // This if Statement checks if the key already exsits inside the Hashmap
           if (letterMappingFlag){
              int numberofLetters = mainCounter.get(c);
              numberofLetters = 1 + numberofLetters;
              mainCounter.replace(c,numberofLetters);
           }
           else {
               mainCounter.put(c,1);
           }

        }
        //Converts the Hashmap to array and creates a array the size of the MAppe Array
        Object[] mappedArray = mainCounter.entrySet().toArray();
        String[] finalStringArray = new String[mappedArray.length];


        //Grabs the Letter, Number of ooccurances
        // then creates letter string with the specifed length.
        // then puts in the TO be sorted array
        for (int i =0; i < mappedArray.length;i++){
            String mappedValue = mappedArray[i].toString();

            char letter = mappedValue.charAt(0);
            int numberReapeating = Integer.parseInt(mappedValue.substring(2));

            String letterRepeat = "";
            for (int z = 0; z < numberReapeating; z++){
                letterRepeat = letterRepeat + letter;
            }

            finalStringArray[i] = letterRepeat;
        }

        //Sorts the Array with a custom built comparator
        Arrays.sort(finalStringArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        //Creates the final String to return
        String finalString = "";

        //Builds the final string to return
        for (int fin = finalStringArray.length-1; fin > -1; fin-- ){
            finalString = finalString + finalStringArray[fin];
        }

        return finalString;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
