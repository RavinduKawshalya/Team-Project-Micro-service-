/* app.js */
document.addEventListener('DOMContentLoaded', function () {
    const resourceForm = document.getElementById('resourceForm');
    const resourcesDiv = document.getElementById('resources');
    const searchForm = document.getElementById('searchForm');
    const searchInput = document.getElementById('searchId');
    const updateButton = document.getElementById('updateButton');
    const deleteButton = document.getElementById('deleteButton');

    function fetchResources() {
        fetch('http://localhost:8080/resources')
            .then(response => response.json())
            .then(data => {
                resourcesDiv.innerHTML = '';
                data.forEach(resource => {
                    const resourceItem = document.createElement('div');
                    resourceItem.className = 'resource-item';
                    resourceItem.innerHTML = `
                        <p><strong>ID:</strong> ${resource.id}</p>
                        <p><strong>Name:</strong> ${resource.name}</p>
                        <p><strong>Type:</strong> ${resource.type}</p>
                        <p><strong>Booking Date:</strong> ${resource.bookingDate}</p>
                        <button class="delete-btn" onclick="deleteResource(${resource.id})">Delete</button>
                        <button onclick="loadResourceForUpdate(${resource.id})">Update</button>
                    `;
                    resourcesDiv.appendChild(resourceItem);
                });
            })
            .catch(error => console.error('Error fetching resources:', error));
    }

    fetchResources();
});
