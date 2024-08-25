document.addEventListener('DOMContentLoaded', function () {
    const dashboardCards = document.querySelectorAll('.dashboard-cards .card');
    const dashboardSection = document.querySelector('.dashboard');

    dashboardCards.forEach(card => {
        card.addEventListener('click', function (event) {
            const targetLink = event.currentTarget.querySelector('a').getAttribute('href');
            loadDashboardContent(targetLink);
            event.preventDefault(); // Prevent default anchor behavior
        });
    });

    function loadDashboardContent(link) {
        // Load content dynamically based on the clicked link
        // For example, you could use AJAX to fetch content and display it in the dashboard
        console.log(`Loading content for ${link}`);

        // Example of replacing content in dashboard
        dashboardSection.innerHTML = `<h2>Loading ${link}...</h2><p>This content would be loaded dynamically based on user interaction.</p>`;

        // In a real-world scenario, you would use fetch or XMLHttpRequest to get data from the server
    }
});
