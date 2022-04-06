package com.example.demo.model;

import java.time.LocalDateTime;

public class Lesson {

  public String title;
  public String description;
  public LocalDateTime dateAndTime;

  public Lesson(String title, String description, LocalDateTime dateAndTime) {
    this.title = title;
    this.description = description;
    this.dateAndTime = dateAndTime;
  }
}
