import React, { useState } from 'react';

import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

import { useLocation } from 'wouter';
import { useUser } from '../../../hooks/useUser';

const AddLanguage = () => {
  const [, navigate] = useLocation();
  const { isLogged, type } = useUser();

  if (!isLogged || type !== 'user') navigate('/');

  const [formData, setFormData] = useState({
    language: '',
    title: '',
    level: '',
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
      <h2>Add Language</h2>
      <Form.Group className="mb-3" controlId="formBasicPersonalData">
        <Form.Label>Language</Form.Label>
        <Form.Select aria-label="Default select example">
          <option disabled>Select language</option>
          <option value="english">English</option>
          <option value="spanish">Spanish</option>
          <option value="german">German</option>
        </Form.Select>

        <Form.Label>Study Title</Form.Label>
        <Form.Control
          name="title"
          type="text"
          placeholder="Type your study title"
          onChange={handleChange}
        />
      </Form.Group>

      <Button variant="primary" type="submit">
        Add
      </Button>
    </Form>
  );
};

export default AddLanguage;
