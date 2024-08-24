document.addEventListener('DOMContentLoaded', function() {
  // Initialize the flatpickr date picker for schedule management
  flatpickr("#scheduleDate", {
      dateFormat: "Y-m-d",     // Format as Year-Month-Day
      minDate: "today",        // Disable past dates
      onChange: function(selectedDates, dateStr, instance) {
          // Set the selected date in the input field
          document.getElementById('scheduleDate').value = dateStr;
      }
  });

  // Handle sidebar navigation (optional enhancement)
  const sidebarLinks = document.querySelectorAll('.sidebar ul li a');
  sidebarLinks.forEach(link => {
      link.addEventListener('click', function(e) {
          e.preventDefault();
          sidebarLinks.forEach(link => link.classList.remove('active'));
          this.classList.add('active');

          // Scroll to the appropriate section instead of hiding/showing sections
          const targetSection = this.getAttribute('href').substring(1);
          document.getElementById(targetSection).scrollIntoView({ behavior: 'smooth' });
      });
  });

  // Ensure all sections are visible and none are hidden
  document.querySelectorAll('section').forEach(section => {
      section.style.display = 'block';
  });

  // Additional functionality for patient cards, doctor cards, etc.
  document.querySelectorAll('.appointment-card').forEach(card => {
      const suggestTestButton = card.querySelector('.suggest-test');
      const suggestMedicationButton = card.querySelector('.suggest-medication');
      
      suggestTestButton.addEventListener('click', function() {
          const testInput = card.querySelector('.test-input');
          const testValue = testInput.value;
          if (testValue) {
              alert('Test suggested: ' + testValue);
              testInput.value = ''; // Clear input after suggesting
          } else {
              alert('Please enter a test name.');
          }
      });

      suggestMedicationButton.addEventListener('click', function() {
          const medicationInput = card.querySelector('.medication-input');
          const medicationValue = medicationInput.value;
          if (medicationValue) {
              alert('Medication suggested: ' + medicationValue);
              medicationInput.value = ''; // Clear input after suggesting
          } else {
              alert('Please enter medication details.');
          }
      });
  });

  // Handle schedule update
  const updateScheduleButton = document.querySelector('#schedules button');
  updateScheduleButton.addEventListener('click', function() {
      const selectedDate = document.getElementById('scheduleDate').value;
      if (selectedDate) {
          alert('Schedule updated for: ' + selectedDate);
      } else {
          alert('Please select a date.');
      }
  });
});
