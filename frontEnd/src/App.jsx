import './App.css';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import HeaderComponent from './components/HeaderComponent';
import React from 'react';
import { Routes, Route } from 'react-router-dom'; // Import Routes instead of BrowserRouter
import FooterComponent from './components/FooterComponent';
import EmployeeComponent from './components/EmployeeComponent';

function App() {
  return (
    <>
      <HeaderComponent />
      <Routes>
        <Route path="/" element={<ListEmployeeComponent />} />
        <Route path="/employees" element={<ListEmployeeComponent />} />
        <Route path="/add-employee" element={<EmployeeComponent/>} />
        <Route path="/edit-employee/:id" element={<EmployeeComponent/>} />
      </Routes>
      <FooterComponent />
    </>
  );
}

export default App;
