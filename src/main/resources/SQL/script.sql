CREATE SCHEMA file_statistic;

USE file_statistic;

CREATE TABLE statistic (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  string_count INT NOT NULL,
  average_words_count FLOAT NOT NULL,
  word_max_length INT NOT NULL,
  word_min_length INT NOT NULL
);