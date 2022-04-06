package com.example.demo.repository;

import com.example.demo.model.Lesson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class LessonRepository {

  public List<Lesson> getAllLessons() {
    String content = readFile();
    return Arrays.stream(content.split("-----")).map(lessonRaw -> {

      final String[] parts = lessonRaw.split("\n");

      final String title = extractElement(parts, "title: ");
      final String description = extractElement(parts, "description: ");
      final String dateAndTime = extractElement(parts, "date: ");
      return new Lesson(title, description, LocalDateTime.parse(dateAndTime));

    }).collect(Collectors.toList());
  }

  private String extractElement(String[] parts, String prefix) {
    return Arrays.stream(parts).filter(p -> p.startsWith(prefix))
        .map(p -> p.substring(prefix.length())).findAny().orElse("");
  }

  private String readFile() {
    try {
      return String.join("\n", Files.readAllLines(Path.of("lessons.txt")));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
