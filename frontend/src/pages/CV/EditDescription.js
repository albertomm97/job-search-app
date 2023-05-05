import React, { useContext, useState } from 'react';

import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

import { useLocation } from 'wouter';
import { useUser } from '../../hooks/useUser';

const EditDescription = () => {
  const [, navigate] = useLocation();
  const { isLogged, userData, type } = useUser();

  if (!isLogged || type !== 'user') navigate('/');

  const [formData, setFormData] = useState({
    description: '',
  });

  const handleAddEditSubmit = (event) => {
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
    <Form className="loginCandidateForm center" onSubmit={handleAddEditSubmit}>
      <h2>Edit Description</h2>
      <Form.Group className="mb-3" controlId="formBasicPersonalData">
        <Form.Label>Description</Form.Label>
        <Form.Control
          as="textarea"
          name="description"
          placeholder="Type job description"
          style={{ height: '200px' }}
          value={userData.description}
          onChange={handleChange}
        />
      </Form.Group>

      <Button variant="primary" type="submit">
        Complete
      </Button>
    </Form>
  );
};

export default EditDescription;
