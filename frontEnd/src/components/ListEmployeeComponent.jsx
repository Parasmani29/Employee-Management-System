// ListEmployeeComponent.js
import React, { useEffect, useState } from 'react';
import { deleteEmployee, listEmployees } from '../services/EmployeeService';
import { useNavigate } from 'react-router-dom';

const ListEmployeeComponent = () => {
    const [employees, setEmployees] = useState([]);
    const navigator = useNavigate();

    useEffect(() => {
        getAllEmployees();
    }, []);

    function getAllEmployees() {
        listEmployees()
            .then((response) => {
                setEmployees(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    }

    function addNewEmployee() {
        navigator('/add-employee');
    }

    function updateEmployee(id) {
        navigator(`/edit-employee/${id}`);
    }

    function removeEmployee(id) {
        deleteEmployee(id)
            .then((response) => {
                getAllEmployees();
            })
            .catch((error) => {
                console.error(error);
            });
    }

    return (
        <div className='container'>
            <h1 className='text-center'>List of Employees</h1>
            <div className="d-flex justify-content-end">
                <button type="button" className="btn btn-outline-primary mb-2 my-2" onClick={addNewEmployee}>+ Add Employee</button>
            </div>
            <table className='table table-striped table-bordered text-center'>
                <thead>
                    <tr>
                        <th>Employee ID</th>
                        <th>Employee First Name</th>
                        <th>Employee Last Name</th>
                        <th>Employee Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {employees.map((employee) => (
                        <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.email}</td>
                            <td>
                                <button className="btn btn-outline-info" onClick={() => updateEmployee(employee.id)}>Update</button>
                                <button type="button" className="btn btn-outline-danger mx-2" onClick={() => removeEmployee(employee.id)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default ListEmployeeComponent;
