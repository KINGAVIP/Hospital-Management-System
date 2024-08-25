document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the form from submitting the traditional way

    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;

    var userRole = authenticateUser(email, password);

    // Redirect the user to their respective homepage based on their role
    if (userRole) {
        if (userRole === 'admin') {
            window.location.href = 'admin.html';
        } else if (userRole === 'doctor') {
            window.location.href = 'doctor.html';
        } else if (userRole === 'patient') {
            window.location.href = 'patient.html';
        }
    } else {
        alert('Invalid credentials, please try again.');
    }
});

// Function to authenticate the user based on email and password
function authenticateUser(email, password) {
    const users = {
        'a@gmail.com': 'admin',
        'b@gmail.com': 'doctor',
        'c@gmail.com': 'patient'
    };
  
    // Placeholder for database authentication (to be implemented)
    if (users[email] && users[email] === password) {
        if (email === 'a@gmail.com') return 'admin';
        if (email === 'b@gmail.com') return 'doctor';
        if (email === 'c@gmail.com') return 'patient';
    }
    return null; // If authentication fails, return null
}
