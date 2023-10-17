import java.util.HashMap;
import java.util.Map;

// lab01, task 5
public class WordFrequencyCounter {
    public static void main(String[] args) {
        String sentence = "This is a test. This is only a test. Testing, one, two, three.";
        Map<String, Integer> wordFrequency = countWordFrequency(sentence);

        System.out.println("Input Sentence: " + sentence);
        System.out.println("Word Frequencies:");

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<String, Integer> countWordFrequency(String sentence) {
        String[] words = sentence.split("[ ,.!?]+");
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase();
            if (wordFrequency.containsKey(word)) {
                wordFrequency.put(word, wordFrequency.get(word) + 1);
            } else {
                wordFrequency.put(word, 1);
            }
        }

        return wordFrequency;
    }
}