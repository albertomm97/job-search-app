import React, { useContext, useState } from 'react';

import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

import { Link } from 'wouter';

const CandidateRegister = () => {
  const [formData, setFormData] = useState({
    name: '',
    surname: '',
    birthDate: '',
    email: '',
    password: '',
  });

  const handleCandidateRegisterSubmit = (event) => {
    event.preventDefault();

    
  };

  const handleChange = (event) => {
    const name = event.target.name;
    setFormData({
      ...formData,
      [name]: formData[name] !== '' ? '' : event.target.value,
    });
  };

  return (
    <Form
      className="loginCandidateForm center"
      onSubmit={handleCandidateRegisterSubmit}
    >
      <h2>Register as a candidate</h2>

      <div className="margin-bottom">
        <h5>Registered yet?</h5>
        <Link to="/candidate-login">
          <Button variant="success">Login here</Button>
        </Link>
      </div>
      <Form.Group className="mb-3" controlId="formBasicPersonalData">
        <h5>Personal data</h5>
        <Form.Label>Name</Form.Label>
        <Form.Control
          name="name"
          type="text"
          placeholder="Type your name"
          onChange={handleChange}
        />
        <Form.Label>Surname</Form.Label>
        <Form.Control
          name="surname"
          type="text"
          placeholder="Type your surname"
          onChange={handleChange}
        />

        <Form.Label>Birthdate</Form.Label>
        <Form.Control name="birthdate" type="date" onChange={handleChange} />
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicAcountData">
        <h5>Account data</h5>
        <Form.Label>Email</Form.Label>
        <Form.Control
          name="email"
          type="email"
          placeholder="Type your email"
          onChange={handleChange}
        />
        <Form.Label>Password</Form.Label>
        <Form.Control
          type="password"
          placeholder="Type your password"
          onChange={handleChange}
        />
      </Form.Group>

      <Button variant="primary" type="submit">
        Register
      </Button>
    </Form>
  );
};

export default CandidateRegister;
