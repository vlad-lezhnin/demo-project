package com.example.demo.controller;

import com.example.demo.model.Lesson;
import com.example.demo.repository.LessonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleApi {

  private final LessonRepository lessonRepository;

  @Autowired
  public ScheduleApi(LessonRepository lessonRepository) {
    this.lessonRepository = lessonRepository;
  }

  @GetMapping("api/schedule")
  public List<Lesson> getAllLessons() {
    return lessonRepository.getAllLessons();
  }
}
