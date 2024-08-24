document.addEventListener('DOMContentLoaded', function() {
  // Add event listeners for form submissions
  document.getElementById('scheduleForm').addEventListener('submit', function(event) {
      event.preventDefault();
      // Add schedule logic here
      alert('Schedule added/updated!');
  });

  document.getElementById('suggestionForm').addEventListener('submit', function(event) {
      event.preventDefault();
      // Submit suggestions logic here
      alert('Suggestions submitted!');
  });

  // Load appointments into the table
  loadAppointments();
});

function loadAppointments() {
  // Simulate fetching appointments from a database
  const appointments = [
      { patientName: 'John Doe', date: '2024-08-25', time: '10:00 AM' },
      { patientName: 'Jane Smith', date: '2024-08-26', time: '02:00 PM' },
  ];

  const tbody = document.getElementById('appointmentsTable').querySelector('tbody');
  tbody.innerHTML = ''; // Clear existing rows

  appointments.forEach(appointment => {
      const tr = document.createElement('tr');
      tr.innerHTML = `
          <td>${appointment.patientName}</td>
          <td>${appointment.date}</td>
          <td>${appointment.time}</td>
          <td><button class="cancel-btn">Cancel</button></td>
      `;
      tbody.appendChild(tr);
  });

  // Add event listeners for cancel buttons
  document.querySelectorAll('.cancel-btn').forEach(button => {
      button.addEventListener('click', function() {
          // Cancel appointment logic here
          alert('Appointment cancelled!');
      });
  });
}


