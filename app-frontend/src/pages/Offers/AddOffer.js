import React, { useContext, useState } from 'react';

import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

import { Link } from 'wouter';

const AddOffer = () => {
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
      <h2>Add Offer</h2>
      <Form.Group className="mb-3" controlId="formBasicPersonalData">
        <Form.Label>Offer Title</Form.Label>
        <Form.Control
          name="title"
          type="text"
          placeholder="Type your study title"
          onChange={handleChange}
        />
        <Form.Label>Offer</Form.Label>
        <Form.Select aria-label="Default select example">
          <option disabled>Select language</option>
          <option value="english">English</option>
          <option value="spanish">Spanish</option>
          <option value="german">German</option>
        </Form.Select>
      </Form.Group>

      <Button variant="primary" type="submit">
        Add
      </Button>
    </Form>
  );
};

export default AddOffer;
