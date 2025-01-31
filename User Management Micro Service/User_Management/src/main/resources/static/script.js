const API_URL = 'http://localhost:8080/users';

async function fetchUsers() {
    const response = await fetch(API_URL);
    const users = await response.json();
    const userList = document.getElementById('users');
    userList.innerHTML = '';
    users.forEach(user => {
        const li = document.createElement('li');
        li.textContent = `ID: ${user.id}, Name: ${user.name}, Email: ${user.email}, Role: ${user.role}`;
        userList.appendChild(li);
    });
}

async function submitUser() {
    const userId = document.getElementById('userId').value;
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const role = document.getElementById('role').value;

    const user = {
        name,
        email,
        password,
        role
    };

    const method = userId ? 'PUT' : 'POST';
    const url = userId ? `${API_URL}/${userId}` : API_URL;

    const response = await fetch(url, {
        method,
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    });

    if (response.ok) {
        fetchUsers();
        document.getElementById('userForm').reset();
        document.getElementById('userId').value = '';
    }
}

async function searchUsers() {
    const name = document.getElementById('searchName').value;
    const role = document.getElementById('searchRole').value;

    let url = `${API_URL}/search_by_name_and_role?name=${name}`;
    if (role) {
        url += `&role=${role}`;
    }

    const response = await fetch(url);
    const users = await response.json();
    const userList = document.getElementById('users');
    userList.innerHTML = '';
    users.forEach(user => {
        const li = document.createElement('li');
        li.textContent = `ID: ${user.id}, Name: ${user.name}, Email: ${user.email}, Role: ${user.role}`;
        userList.appendChild(li);
    });
}

document.addEventListener('DOMContentLoaded', fetchUsers);