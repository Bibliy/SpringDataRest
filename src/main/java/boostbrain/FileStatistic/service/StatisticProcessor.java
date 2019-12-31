package boostbrain.FileStatistic.service;

import boostbrain.FileStatistic.model.Statistic;
import org.springframework.stereotype.Service;

//logic interactions with our Model
@Service
public class StatisticProcessor {
    public Statistic getStatistic(byte[] data) {

        int stringCount, totalWordCount = 0, minLength = Integer.MAX_VALUE, maxLength = 0;

        String input = new String(data);
        String[] array = input.split("\n");
        stringCount = array.length;

        for (String line: array) {
            String[] words = line.split(" "); //there is check for empty strings below, so trim() is not necessary
            for (String word: words) {
                if (word.length() == 0) continue;
                totalWordCount++;
                if (word.length() > maxLength) maxLength = word.length();
                if (word.length() < minLength) minLength = word.length();
            }
        }
        return new Statistic(stringCount, totalWordCount/stringCount, maxLength, minLength);
    }
}
