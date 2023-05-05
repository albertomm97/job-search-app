import React, { useState } from 'react';

import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

import { useLocation } from 'wouter';
import { useUser } from '../../../hooks/useUser';

import { addWorkExperience } from '../../../services/CV/cvService';

const AddWorkExperience = () => {
  const [, navigate] = useLocation();
  const { isLogged, type } = useUser();

  if (!isLogged || type !== 'user') navigate('/');

  const [formData, setFormData] = useState({
    id: '2',
    title: '',
    company: '',
    startDate: '',
    endDate: '',
    //category: '',
    description: '',
    currentlyWorking: false,
  });

  const handleAddWorkExperienceSubmit = (event) => {
    event.preventDefault();

    console.log(formData);

    addWorkExperience(formData);
    navigate('/cv');
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
      onSubmit={handleAddWorkExperienceSubmit}
    >
      <h2>Add Work Experience</h2>
      <Form.Group className="mb-3" controlId="formBasicPersonalData">
        <Form.Label>Company Name</Form.Label>
        <Form.Control
          name="company"
          type="text"
          placeholder="Company name"
          onChange={handleChange}
        />
        <Form.Label>Job Title</Form.Label>
        <Form.Control
          name="title"
          type="text"
          placeholder="Type your surname"
          onChange={handleChange}
        />
        <Form.Label>Job Category</Form.Label>
        <Form.Select aria-label="Default select example">
          <option disabled>Select Job Category</option>
          <option value="backend">Backend</option>
          <option value="frontend">Frontend</option>
          <option value="fullstack">Fullstack</option>
        </Form.Select>
        <Form.Label>Description</Form.Label>
        <Form.Control
          as="textarea"
          name="description"
          placeholder="Type job description"
          style={{ height: '200px' }}
          onChange={handleChange}
        />

        <Form.Label>Currently working here</Form.Label>
        <Form.Check
          name="currentlyWorking"
          value="yes"
          label="Yes"
          type="radio"
          onChange={handleChange}
        />
        <Form.Check
          name="currentlyWorking"
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

export default AddWorkExperience;
