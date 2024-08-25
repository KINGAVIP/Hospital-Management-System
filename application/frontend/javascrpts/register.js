document.addEventListener('DOMContentLoaded', function () {
    const registerForm = document.getElementById('registerForm');
    const password = document.getElementById('password');
    const confirmPassword = document.getElementById('confirmPassword');

    registerForm.addEventListener('submit', function (event) {
        // Basic validation for matching passwords
        if (password.value !== confirmPassword.value) {
            alert('Passwords do not match!');
            event.preventDefault(); // Prevent form submission
        }
    });

    // Additional validation or functionality can be added here
});
