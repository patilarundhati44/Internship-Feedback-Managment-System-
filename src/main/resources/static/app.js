document.getElementById("feedbackForm").addEventListener("submit", async function (e) {
  e.preventDefault();

  const feedback = {
    studentName: document.getElementById("studentName").value,
    topic: document.getElementById("topic").value,
    feedback: document.getElementById("feedback").value,
    rating: parseInt(document.getElementById("rating").value)
  };

  const response = await fetch("http://localhost:8080/api/feedback", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(feedback)
  });

  if (response.ok) {
    alert("Feedback submitted!");
    loadFeedbacks();
    document.getElementById("feedbackForm").reset();
  }
});

async function loadFeedbacks() {
  const res = await fetch("http://localhost:8080/api/feedback");
  const data = await res.json();
  const list = data.map(f =>
    `<div><b>${f.studentName}</b> (${f.topic}) - Rating: ${f.rating}<br>${f.feedback}</div><hr>`
  ).join('');
  document.getElementById("feedbackList").innerHTML = list;
}

window.onload = loadFeedbacks;
