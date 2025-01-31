document.addEventListener('DOMContentLoaded', () => {
    fetchResources();

    // Add or update resource
    document.getElementById('resourceForm').addEventListener('submit', handleFormSubmit);

    // Search resource by ID
    document.getElementById('searchForm').addEventListener('submit', handleSearch);

    // Delete resource
    document.getElementById('deleteButton').addEventListener('click', handleDelete);
});

// Fetch and display all resources
async function fetchResources() {
    const resourcesDiv = document.getElementById('resources');
    const loadingDiv = document.getElementById('loading');

    try {
        loadingDiv.style.display = 'block';
        resourcesDiv.innerHTML = '';

        const response = await fetch('/api/resources');
        const data = await response.json();

        loadingDiv.style.display = 'none';

        if (data.length === 0) {
            resourcesDiv.innerHTML = '<p>No resources available.</p>';
        } else {
            data.forEach(resource => {
                resourcesDiv.innerHTML += `
                    <div class="resource">
                        <h2>${resource.resource_name}</h2>
                        <p>ID: ${resource.id}</p>
                        <p>Type: ${resource.resource_type}</p>
                        <p>Booking Date: ${new Date(resource.booking_date).toLocaleDateString()}</p>
                    </div>`;
            });
        }
    } catch (error) {
        displayNotification('Error fetching resources!', 'error');
        loadingDiv.style.display = 'none';
    }
}

// Handle form submission (add/update)
async function handleFormSubmit(event) {
    event.preventDefault();

    const resourceId = document.getElementById('resourceId').value;
    const resource = {
        resource_name: document.getElementById('resourceName').value.trim(),
        resource_type: document.getElementById('resourceType').value,
        booking_date: document.getElementById('bookingDate').value
    };

    if (!resource.resource_name || !resource.booking_date) {
        displayNotification('Please fill in all fields.', 'warning');
        return;
    }

    const method = resourceId ? 'PUT' : 'POST';
    const url = resourceId ? `/api/resources/${resourceId}` : '/api/resources';

    try {
        const response = await fetch(url, {
            method,
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(resource)
        });

        if (!response.ok) throw new Error('Error saving resource!');

        displayNotification('Resource saved successfully!', 'success');
        fetchResources();
        resetForm();
    } catch (error) {
        displayNotification(error.message, 'error');
    }
}

// Handle search by ID
async function handleSearch(event) {
    event.preventDefault();

    const id = document.getElementById('searchId').value.trim();
    if (!id) {
        displayNotification('Please enter a valid ID.', 'warning');
        return;
    }

    try {
        const response = await fetch(`/api/resources/${id}`);
        if (!response.ok) throw new Error('Resource not found!');

        const data = await response.json();

        document.getElementById('resourceId').value = data.id;
        document.getElementById('resourceName').value = data.resource_name;
        document.getElementById('resourceType').value = data.resource_type;
        document.getElementById('bookingDate').value = data.booking_date.split('T')[0];

        toggleButtons(true);
    } catch (error) {
        displayNotification(error.message, 'error');
    }
}

// Handle delete
async function handleDelete() {
    const id = document.getElementById('resourceId').value;
    if (!id) {
        displayNotification('Select a resource first!', 'warning');
        return;
    }

    try {
        const response = await fetch(`/api/resources/${id}`, { method: 'DELETE' });
        if (!response.ok) throw new Error('Error deleting resource!');

        displayNotification('Resource deleted successfully!', 'success');
        fetchResources();
        resetForm();
    } catch (error) {
        displayNotification(error.message, 'error');
    }
}

// Reset form and hide update/delete buttons
function resetForm() {
    document.getElementById('resourceForm').reset();
    document.getElementById('resourceId').value = '';

    toggleButtons(false);
}

// Toggle update/delete button visibility
function toggleButtons(showUpdate) {
    document.getElementById('addButton').style.display = showUpdate ? 'none' : 'inline';
    document.getElementById('updateButton').class