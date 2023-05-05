import React, { useContext, useState } from 'react';

import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

import { Link } from 'wouter';

const CompanyRegister = () => {
  const [formData, setFormData] = useState({
    name: '',
    surname: '',
    email: '',
    password: '',
    companyName: '',
    companyDescription: '',
  });

  const handleCompanyRegisterSubmit = (event) => {
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
      onSubmit={handleCompanyRegisterSubmit}
    >
      <h2>Register as a company</h2>

      <div className="margin-bottom">
        <h5>Registered yet?</h5>
        <Link to="/company-login">
          <Button variant="success">Login here</Button>
        </Link>
      </div>
      <Form.Group className="mb-3" controlId="formBasicPersonalData">
        <h5>Access data to app</h5>
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
          placeholder="Password"
          onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicPassword">
        <h5>Company data</h5>
        <Form.Label>Company name</Form.Label>
        <Form.Control
          name="companyName"
          type="text"
          placeholder="Type company name"
          onChange={handleChange}
        />
        <Form.Label>Company description</Form.Label>
        <Form.Control
          as="textarea"
          name="companyDescription"
          placeholder="Type company description"
          style={{ height: '200px' }}
          onChange={handleChange}
        />
      </Form.Group>

      <Button variant="primary" type="submit">
        Register
      </Button>
    </Form>
  );
};

export default CompanyRegister;
