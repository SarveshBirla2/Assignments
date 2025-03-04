const API_URL = "https://crudcrud.com/api/ec9499fff3f1466a8e9e21d1379d0e15/empapp";


function showAddForm() {
    document.getElementById("form-container").innerHTML = `
        <h3>Add Employee</h3>
        <form onsubmit="addEmployee(event)">
            <input type="text" id="name" placeholder="Name" required>
            <input type="number" id="age" placeholder="Age" min="18" max="60" required>
            <input type="number" id="salary" placeholder="Salary (Min 10000)" min="10000" required>
            <select id="designation" required>
                <option value="Clerk">Clerk</option>
                <option value="Programmer">Programmer</option>
                <option value="Manager">Manager</option>
                <option value="CEO">CEO</option>
            </select>
            <button type="submit">Submit</button>
        </form>
    `;
}


async function addEmployee(event) {
    event.preventDefault();

    const employee = {
        name: document.getElementById("name").value,
        age: parseInt(document.getElementById("age").value),
        salary: parseFloat(document.getElementById("salary").value),
        designation: document.getElementById("designation").value
    };

    try {
        const response = await fetch(API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(employee)
        });

        if (!response.ok) throw new Error("Failed to add employee");

        alert("Employee Added!");
        document.getElementById("form-container").innerHTML = "";
    } catch (error) {
        alert(error.message);
    }
}


async function displayEmployees() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error("Failed to fetch employees");

        const employees = await response.json();
        let output = "<h3>Employee List</h3>";
        employees.forEach(emp => {
            output += `<p><b>ID:</b> ${emp._id} | <b>Name:</b> ${emp.name} | <b>Age:</b> ${emp.age} | <b>Salary:</b> ${emp.salary} | <b> Designation: </b> ${emp.designation}</p>`;
        });

        document.getElementById("output").innerHTML = output;
    } catch (error) {
        alert(error.message);
    }
}


function showUpdateForm() {
    document.getElementById("form-container").innerHTML = `
        <h3>Update Employee</h3>
        <input type="text" id="update-id" placeholder="Enter Employee ID">
        <button onclick="updateEmployee()">Find</button>
    `;
}


async function updateEmployee() {
    const id = document.getElementById("update-id").value;
    try {
        const response = await fetch(`${API_URL}/${id}`);
        if (!response.ok) throw new Error("Employee not found");

        const emp = await response.json();

        document.getElementById("form-container").innerHTML = `
            <h3>Update Employee</h3>
            <form onsubmit="saveUpdatedEmployee(event, '${id}')">
                <input type="text" id="name" value="${emp.name}" required>
                <input type="number" id="age" value="${emp.age}" min="18" max="60" required>
                <input type="number" id="salary" value="${emp.salary}" min="10000" required>
                <select id="designation" required>
                    <option value="Clerk" ${emp.designation === "Clerk" ? "selected" : ""}>Clerk</option>
                    <option value="Programmer" ${emp.designation === "Programmer" ? "selected" : ""}>Programmer</option>
                    <option value="Manager" ${emp.designation === "Manager" ? "selected" : ""}>Manager</option>
                    <option value="CEO" ${emp.designation === "CEO" ? "selected" : ""}>CEO</option>
                </select>
                <button type="submit">Save</button>
            </form>
        `;
    } catch (error) {
        alert(error.message);
    }
}


async function saveUpdatedEmployee(event, id) {
    event.preventDefault();

    const updatedEmployee = {
        name: document.getElementById("name").value,
        age: parseInt(document.getElementById("age").value),
        salary: parseFloat(document.getElementById("salary").value),
        designation: document.getElementById("designation").value
    };

    try {
        const response = await fetch(`${API_URL}/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(updatedEmployee)
        });

        if (!response.ok) throw new Error("Failed to update employee");

        alert("Employee Updated!");
        document.getElementById("form-container").innerHTML = "";
    } catch (error) {
        alert(error.message);
    }
}

function showSearchForm() {
    document.getElementById("form-container").innerHTML = `
        <h3>Search Employee</h3>
        <input type="text" id="search-id" placeholder="Enter Employee ID">
        <button onclick="searchEmployee()">Search</button>
    `;
}


async function searchEmployee() {
    const id = document.getElementById("search-id").value;
    try {
        const response = await fetch(`${API_URL}/${id}`);
        if (!response.ok) throw new Error("Employee not found");

        const emp = await response.json();
        document.getElementById("output").innerHTML = `
            <h3>Employee Details</h3>
            <p>ID: ${emp._id}, Name: ${emp.name}, Age: ${emp.age}, Salary: ${emp.salary}, Designation: ${emp.designation}</p>
        `;
    } catch (error) {
        alert(error.message);
    }
}


function showDeleteForm() {
    document.getElementById("form-container").innerHTML = `
        <h3>Delete Employee</h3>
        <input type="text" id="delete-id" placeholder="Enter Employee ID">
        <button onclick="deleteEmployee()">Delete</button>
    `;
}

async function deleteEmployee() {
    const id = document.getElementById("delete-id").value;
    try {
        const response = await fetch(`${API_URL}/${id}`, {
            method: "DELETE"
        });

        if (!response.ok) throw new Error("Failed to delete employee");

        alert("Employee Deleted!");
        document.getElementById("output").innerHTML = "";
    } catch (error) {
        alert(error.message);
    }
}
