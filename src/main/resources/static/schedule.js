window.addEventListener("load", () => {
  $.get("/api/schedule", function (lessons) {
    var listHtml = lessons.map(lesson => {
      var lessonHtml = `
      <div class="lesson-component">
            <h3>${lesson.title}</h3>
            <div>When: <b>${new Date(lesson.dateAndTime).toLocaleString("uk")}</b></div>
            <div>${lesson.description}</div>
      </div>`;
      return lessonHtml
    }).join("");
    $(".lessons-list").html(listHtml);
  });
});
