package com.example.demo.controller;

import com.example.demo.model.Lesson;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleApi {

  @GetMapping("api/schedule")
  public List<Lesson> getAllLessons() {
    return List.of(
        new Lesson("Intro into Software Engineer role",
            "Друзі, 6го квітня о 19:00 за Києвом ми будемо розмовляти про роль Інженера програмного забезпечення(девелопера).",
            LocalDateTime.of(2022, Month.APRIL, 6, 18, 0)
        ),
        new Lesson("Intro into QA",
            "Introduction into QA",
            LocalDateTime.of(2022, Month.APRIL, 1, 18, 0)
        ),
        new Lesson("Intro into SCRUM",
            "Introduction into Agile and Scrum",
            LocalDateTime.of(2022, Month.MARCH, 1, 18, 0)
        )
    );
  }
}
