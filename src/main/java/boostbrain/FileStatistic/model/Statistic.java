package boostbrain.FileStatistic.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "statistic")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Statistic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "string_count")
    private int stringsCount;

    @Column(name = "average_words_count")
    private double averageWords;

    @Column(name = "word_max_length")
    private int wordMaxLength;

    @Column(name = "word_min_length")
    private int wordMinLength;

    private Exception exception;

    public Statistic(int stringsCount, double averageWords, int wordMaxLength, int wordMinLength) {
        this.stringsCount = stringsCount;
        this.averageWords = averageWords;
        this.wordMaxLength = wordMaxLength;
        this.wordMinLength = wordMinLength;
    }

    public Statistic() {
    }

    public Statistic(Exception exception) {
        this.exception = exception;
    }
}
