
// 3 types of users => admin, doctor, patient
// different homepage for each based on user 


document.getElementById('loginForm').addEventListener('submit', function(event) {
  event.preventDefault();

  var email = document.getElementById('email').value;
  var password = document.getElementById('password').value;

  var userRole = authenticateUser(email, password);


  //AFTER LOGIN=> REDIRECT TO THEIR OWN HOMEPAGE
  if (userRole) {
      
      if (userRole === 'admin') {
          window.location.href = 'admin.html';
      } else if (userRole === 'doctor') {
          window.location.href = 'doctor.html';
      } else if (userRole === 'patient') {
          window.location.href = 'patient.html';
      }
  } 
  
  // INVALID USER HAS TO LOGIN AGAIN===============
  else {
      alert('Invalid credentials, please try again.');
  }
});


function authenticateUser(email, password) {
  
  // HAVE TO GET FROM DB => TO-DO ==================================
  const users = {
      'a@gmail.com': 'admin',
      'b@gmail.com': 'doctor',
      'c@gmail.com': 'patient'
  };

  if (users[email] && users[email] === password) {
      if (email === 'a@gmail.com') return 'admin';
      if (email === 'b@gmail.com') return 'doctor';
      if (email === 'c@gmail.com') return 'patient';
  }
  return null;
}
