const apiBaseUrl = "http://localhost:8098/api/feedback";

function submitFeedback(event) 

{
    event.preventDefault(); 

    const studentName = document.getElementById("studentName").value;
    const topic = document.getElementById("topic").value;
    const feedbackText = document.getElementById("feedback").value;
    const rating = document.getElementById("rating").value;
    const lecturer = document.getElementById("lecturer").value;
    const subject = document.getElementById("subject").value;
    const lectureDate = document.getElementById("lectureDate").value;

    const feedbackData = 
    
    {
        studentName,
        topic,
        feedback: feedbackText,
        rating,
        lecturer,
        subject,
        lectureDate
    };

    fetch(apiBaseUrl, 
          
      {
        method: "POST",
        headers: 
        
        {
            "Content-Type": "application/json"
        },
        
        body: JSON.stringify(feedbackData)
    })
    .then(response => 
      
      {
        if (!response.ok) 
        
        {
            throw new Error("Failed to submit feedback");
        }
        return response.json();
    })
    .then(data => 
      
      {
        alert("Feedback submitted successfully!");
        fetchAllFeedbacks();
        clearForm();
    })
    .catch(error => {
        alert("Error: " + error.message);
    });
}


function fetchAllFeedbacks() {
    fetch(apiBaseUrl)
        .then(response => response.json())
        .then(data => {
            const tableBody = document.querySelector("#feedbackTable tbody");
            tableBody.innerHTML = "";

            data.forEach(item => {
                const row = `
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.studentName}</td>
                        <td>${item.topic}</td>
                        <td>${item.feedback}</td>
                        <td>${item.rating}</td>
                        <td>${item.lecturer}</td>
                        <td>${item.subject}</td>
                        <td>${item.lectureDate}</td>
                        <td><button onclick="deleteFeedback(${item.id})">Delete</button></td>
                    </tr>
                `;
                tableBody.innerHTML += row;
            });
        })
        .catch(error => {
            console.error("Failed to fetch feedbacks:", error);
        });
}

// DELETE - Feedback by ID
function deleteFeedback(id) {
    fetch(`${apiBaseUrl}/${id}`, {
        method: "DELETE"
    })
    .then(() => {
        alert("Feedback deleted successfully.");
        fetchAllFeedbacks();
    })
    .catch(error => {
        alert("Failed to delete feedback.");
    });
}


function clearForm() {
    document.getElementById("studentName").value = "";
    document.getElementById("topic").value = "";
    document.getElementById("feedback").value = "";
    document.getElementById("rating").value = "";
    document.getElementById("lecturer").value = "";
    document.getElementById("subject").value = "";
    document.getElementById("lectureDate").value = "";
}

document.addEventListener("DOMContentLoaded", () => 
  
  {
    fetchAllFeedbacks();
    document.getElementById("feedbackForm").addEventListener("submit", submitFeedback);
});
