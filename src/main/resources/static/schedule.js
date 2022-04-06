window.addEventListener("load", () => {
  $.get( "/api/schedule", function(lessons) {
    var listHtml = lessons.map(lesson => `
      <h3>${lesson.title}</h3>
      <div>When: <b>${lesson.dateAndTime}</b></div>
      <div>${lesson.description}</div>
    `).join("");
    $(".lessons-list").html(listHtml);
  });
});
