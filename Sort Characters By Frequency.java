//Given a string s, sort it in decreasing order based on the frequency of the
//characters. The frequency of a character is the number of times it appears in the
//string.
//
// Return the sorted string. If there are multiple answers, return any of them.
//
//
//
// Example 1:
//
//
//Input: s = "tree"
//Output: "eert"
//Explanation: 'e' appears twice while 'r' and 't' both appear once.
//So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid
//answer.
//
//
// Example 2:
//
//
//Input: s = "cccaaa"
//Output: "aaaccc"
//Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and
//"aaaccc" are valid answers.
//Note that "cacaca" is incorrect, as the same characters must be together.
//
//
// Example 3:
//
//
//Input: s = "Aabb"
//Output: "bbAa"
//Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
//Note that 'A' and 'a' are treated as two different characters.
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 5 * 10⁵
// s consists of uppercase and lowercase English letters and digits.
//
// Related Topics Hash Table String Sorting Heap (Priority Queue) Bucket Sort
//Counting 👍 3301 👎 165


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
