// Calendar picker for booking appointment
document.addEventListener('DOMContentLoaded', function() {
  const appointmentDateInput = document.getElementById('appointment-date');
  flatpickr(appointmentDateInput, {
      dateFormat: 'd-m-Y',
      minDate: 'today',
      onChange: function(selectedDates, dateStr, instance) {
          appointmentDateInput.value = dateStr;
      }
  });
});

document.getElementById('addPatientForm').addEventListener('submit', function(event) {
  event.preventDefault();

  const patientName = document.getElementById('patientName').value;
  const patientEmail = document.getElementById('patientEmail').value;
  const patientPhone = document.getElementById('patientPhone').value;
  const appointmentDate = document.getElementById('appointmentDate').value;

  // Here, add the logic to store the new patient information.
  // For now, we will just log it to the console for demonstration.
  console.log('New Patient:', {
      name: patientName,
      email: patientEmail,
      phone: patientPhone,
      date: appointmentDate
  });

  alert('Patient added successfully!');
  // Optionally, reset the form after adding the patient.
  document.getElementById('addPatientForm').reset();
});

// Form submission for booking appointment
document.getElementById('appointment-form').addEventListener('submit', function(event) {
  event.preventDefault();
  const doctor = document.getElementById('doctor-select').value;
  const date = document.getElementById('appointment-date').value;
  
  if (doctor && date) {
      alert(`Appointment booked with ${doctor} on ${date}`);
  } else {
      alert('Please select a doctor and date.');
  }
});

// Cancel appointment functionality
document.querySelectorAll('.cancel-appointment').forEach(button => {
  button.addEventListener('click', function() {
      if (confirm('Are you sure you want to cancel this appointment?')) {
          this.closest('.card').remove();
      }
  });
});
