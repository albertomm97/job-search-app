import React, { useEffect, useState } from 'react';

import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

import { Link } from 'wouter';
import { useLocation } from 'wouter';

import { useUser } from '../../hooks/useUser';

const CandidateLogin = () => {
  const [formData, setFormData] = useState({
    email: '',
    password: '',
  });
  const [, navigate] = useLocation();
  const { login, isLogged } = useUser();

  useEffect(() => {
    if (isLogged) navigate('/');
  }, [isLogged, navigate]);

  const handleCandidateLoginSubmit = (event) => {
    event.preventDefault();

    login(formData, 'user');
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
      onSubmit={handleCandidateLoginSubmit}
    >
      <h2>Access as a candidate</h2>

      <div className="margin-bottom">
        <h5>Not registered yet?</h5>
        <Link to="/candidate-register">
          <Button variant="success">Register here</Button>
        </Link>
      </div>
      <Form.Group className="mb-3" controlId="formBasicEmail">
        <Form.Label>Email address</Form.Label>
        <Form.Control
          type="email"
          placeholder="Enter email"
          onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicPassword">
        <Form.Label>Password</Form.Label>
        <Form.Control
          type="password"
          placeholder="Password"
          onChange={handleChange}
        />
      </Form.Group>

      <Button variant="primary" type="submit">
        Login
      </Button>
    </Form>
  );
};

export default CandidateLogin;
