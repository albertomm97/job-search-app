import React, { useState } from 'react';

import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

import { useLocation } from 'wouter';
import { useUser } from '../../../hooks/useUser';

const EditWorkExperience = ({ params }) => {
  const [, navigate] = useLocation();
  const { isLogged, userData, type } = useUser();

  if (!isLogged || type !== 'user') navigate('/');

  const experience = userData.workExperience.find(
    (exp) => exp.id === params.id
  );

  console.log(params);
  if (!experience) console.log('EXPERIENCE NULL');

  const [formData, setFormData] = useState({
    company: experience.company,
    title: experience.title,
    startDate: experience.startDate,
    endDate: experience.endDate,
    currentlyWorking: experience.currentlyWorking,
    description: experience.description,
  });

  const handleAddWorkExperienceSubmit = (event) => {
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
      onSubmit={handleAddWorkExperienceSubmit}
    >
      <h2>Edit Work Experience</h2>
      <Form.Group className="mb-3" controlId="formBasicPersonalData">
        <Form.Label>Company Name</Form.Label>
        <Form.Control
          name="company"
          type="text"
          placeholder="Company name"
          value={formData.company}
          onChange={handleChange}
        />
        <Form.Label>Job Title</Form.Label>
        <Form.Control
          name="title"
          type="text"
          placeholder="Type your surname"
          value={formData.title}
          onChange={handleChange}
        />
        <Form.Label>Description</Form.Label>
        <Form.Control
          as="textarea"
          name="description"
          placeholder="Type job description"
          style={{ height: '200px' }}
          value={formData.description}
          onChange={handleChange}
        />

        <Form.Label>Currently working here</Form.Label>
        <Form.Check
          name="currentlyWorking"
          value={true}
          label="Yes"
          type="radio"
          onChange={handleChange}
        />
        <Form.Check
          name="currentlyWorking"
          value={false}
          label="No"
          type="radio"
          onChange={handleChange}
        />

        <Form.Label>Start Date</Form.Label>
        <Form.Control
          name="birthdate"
          type="date"
          onChange={handleChange}
          value={formData.startDate}
        />

        <Form.Label>End Date</Form.Label>
        <Form.Control
          name="birthdate"
          type="date"
          onChange={handleChange}
          value={formData.startDate}
        />
      </Form.Group>

      <Button variant="primary" type="submit">
        Complete
      </Button>
    </Form>
  );
};

export default EditWorkExperience;
