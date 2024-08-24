// scripts.js
document.addEventListener('DOMContentLoaded', () => {
    const importUsersBtn = document.getElementById('importUsersBtn');
    const showDoctorsBtn = document.getElementById('showDoctorsBtn');
    const cancelAppointmentsBtn = document.getElementById('cancelAppointmentsBtn');
    const showPatientsBtn = document.getElementById('showPatientsBtn');

    const importUsersSection = document.getElementById('importUsersSection');
    const showDoctorsSection = document.getElementById('showDoctorsSection');
    const cancelAppointmentsSection = document.getElementById('cancelAppointmentsSection');
    const showPatientsSection = document.getElementById('showPatientsSection');

    importUsersBtn.addEventListener('click', () => {
        toggleSection(importUsersSection);
    });

    showDoctorsBtn.addEventListener('click', () => {
        toggleSection(showDoctorsSection);
        populateDoctors();
    });

    cancelAppointmentsBtn.addEventListener('click', () => {
        toggleSection(cancelAppointmentsSection);
        populateDoctorsForCancel();
    });

    showPatientsBtn.addEventListener('click', () => {
        toggleSection(showPatientsSection);
        populatePatients();
    });

    function toggleSection(section) {
        const sections = [importUsersSection, showDoctorsSection, cancelAppointmentsSection, showPatientsSection];
        sections.forEach(sec => sec.classList.add('hidden'));
        section.classList.remove('hidden');
    }

    function populateDoctors() {
        // Example code for populating doctor select options
        const doctorSelect = document.getElementById('doctorSelect');
        doctorSelect.innerHTML = ''; // Clear existing options

        // Fetch doctors (example static data)
        const doctors = [
            { id: 1, name: 'Dr. A' },
            { id: 2, name: 'Dr. B' },
            { id: 3, name: 'Dr. C' },
            { id: 4, name: 'Dr. D' },
            { id: 5, name: 'Dr. E' },
        ];

        doctors.forEach(doctor => {
            const option = document.createElement('option');
            option.value = doctor.id;
            option.textContent = doctor.name;
            doctorSelect.appendChild(option);
        });

        doctorSelect.addEventListener('change', function() {
            const selectedDoctorId = this.value;
            displayDoctorSchedule(selectedDoctorId);
        });
    }

    function displayDoctorSchedule(doctorId) {
        // Example code for displaying doctor schedule
        const doctorSchedule = document.getElementById('doctorSchedule');
        doctorSchedule.innerHTML = ''; // Clear existing schedule

        // Fetch schedule (example static data)
        const schedule = [
            { day: 'Monday', hours: '9 AM - 5 PM' },
            { day: 'Tuesday', hours: '9 AM - 5 PM' },
            
            // Add more days as needed
        ];

        const scheduleList = document.createElement('ul');
        schedule.forEach(entry => {
            const listItem = document.createElement('li');
            listItem.textContent = `${entry.day}: ${entry.hours}`;
            scheduleList.appendChild(listItem);
        });

        doctorSchedule.appendChild(scheduleList);
    }

    function populateDoctorsForCancel() {
        // Similar to populateDoctors but for canceling appointments
        const cancelDoctorSelect = document.getElementById('cancelDoctorSelect');
        cancelDoctorSelect.innerHTML = ''; // Clear existing options

        // Fetch doctors (example static data)
        const doctors = [
            { id: 1, name: 'Dr. A' },
            { id: 2, name: 'Dr. B' },
            { id: 3, name: 'Dr. C' },
            { id: 4, name: 'Dr. D' },
            { id: 5, name: 'Dr. E' },
        ];

        doctors.forEach(doctor => {
            const option = document.createElement('option');
            option.value = doctor.id;
            option.textContent = doctor.name;
            cancelDoctorSelect.appendChild(option);
        });

        cancelDoctorSelect.addEventListener('change', function() {
            const selectedDoctorId = this.value;
            displayAppointments(selectedDoctorId);
        });
    }

    function displayAppointments(doctorId) {
        // Example code for displaying appointments
        const appointmentsList = document.getElementById('appointmentsList');
        appointmentsList.innerHTML = ''; // Clear existing appointments

        // Fetch appointments (example static data)
        const appointments = [
            { time: '10:00 AM', patient: 'Patient A' },
            { time: '11:00 AM', patient: 'Patient B' },
            // Add more appointments as needed
        ];

        const appointmentsTable = document.createElement('table');
        const thead = document.createElement('thead');
        const tbody = document.createElement('tbody');

        thead.innerHTML = `
            <tr>
                <th>Time</th>
                <th>Patient</th>
            </tr>
        `;

        appointments.forEach(appointment => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${appointment.time}</td>
                <td>${appointment.patient}</td>
            `;
            tbody.appendChild(row);
        });

        appointmentsTable.appendChild(thead);
        appointmentsTable.appendChild(tbody);
        appointmentsList.appendChild(appointmentsTable);
    }

    function populatePatients() {
        // Example code for populating patient list
        const patientsList = document.getElementById('patientsList');
        patientsList.innerHTML = ''; // Clear existing patients

        // Fetch patients (example static data)
        const patients = [
            { id: 1, name: 'Patient A', age: 30, condition: 'Condition A' },
            { id: 2, name: 'Patient B', age: 40, condition: 'Condition B' },
        ];

        const patientTable = document.createElement('table');
        const thead = document.createElement('thead');
        const tbody = document.createElement('tbody');

        thead.innerHTML = `
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Condition</th>
            </tr>
        `;

        patients.forEach(patient => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${patient.id}</td>
                <td>${patient.name}</td>
                <td>${patient.age}</td>
                <td>${patient.condition}</td>
            `;
            tbody.appendChild(row);
        });

        patientTable.appendChild(thead);
        patientTable.appendChild(tbody);
        patientsList.appendChild(patientTable);
    }

    // Form submission for importing users
    document.getElementById('importUsersForm').addEventListener('submit', function(event) {
        event.preventDefault();
        const fileInput = document.getElementById('fileUpload');
        const file = fileInput.files[0];

        if (!file) {
            alert('Please select a file to upload.');
            return;
        }

        const reader = new FileReader();
        reader.onload = function(e) {
            const fileContent = e.target.result;
            // Example file processing (JSON/XML parsing)
            console.log(fileContent); // Process file content here
            document.getElementById('importStatus').textContent = 'Import successful!';
        };

        reader.readAsText(file);
    });
});
