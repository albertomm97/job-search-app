import React, { useState } from 'react';

import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

import { useLocation } from 'wouter';
import { useUser } from '../../../hooks/useUser';

const AddStudy = () => {
  const [, navigate] = useLocation();
  const { isLogged, type } = useUser();

  if (!isLogged || type !== 'user') navigate('/');

  const [formData, setFormData] = useState({
    category: '',
    title: '',
    startDate: '',
    endDate: '',
    currentlyStudying: '',
    university: '',
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
      <h2>Add Study</h2>
      <Form.Group className="mb-3" controlId="formBasicPersonalData">
        <Form.Label>Study Level</Form.Label>
        <Form.Select aria-label="Default select example">
          <option disabled>Select Study Level</option>
          <option value="nothing">No studies</option>
          <option value="highschool">High School</option>
          <option value="degree">Degree</option>
        </Form.Select>

        <Form.Label>Study Title</Form.Label>
        <Form.Control
          name="title"
          type="text"
          placeholder="Type your study title"
          onChange={handleChange}
        />

        <Form.Label>Study Center</Form.Label>
        <Form.Control
          name="center"
          type="text"
          placeholder="Type your study center"
          onChange={handleChange}
        />

        <Form.Label>Currently studying here</Form.Label>
        <Form.Check
          name="currentlyStudying"
          value="yes"
          label="Yes"
          type="radio"
          onChange={handleChange}
        />
        <Form.Check
          name="currentlyStudying"
          value="no"
          label="No"
          type="radio"
          onChange={handleChange}
        />

        <Form.Label>Start Date</Form.Label>
        <Form.Control name="startDate" type="date" onChange={handleChange} />

        <Form.Label>End Date</Form.Label>
        <Form.Control name="endDate" type="date" onChange={handleChange} />
      </Form.Group>

      <Button variant="primary" type="submit">
        Add
      </Button>
    </Form>
  );
};

export default AddStudy;
