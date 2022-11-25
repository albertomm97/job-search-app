import React, { useState } from 'react';

import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

import { useLocation } from 'wouter';
import { useUser } from '../../../hooks/useUser';

const EditStudy = ({ params }) => {
  const [, navigate] = useLocation();
  const { isLogged, userData, type } = useUser();

  if (!isLogged || type !== 'user') navigate('/');

  const study = userData.studies.find((exp) => exp.id === params.id);

  console.log(params);
  if (!study) console.log('STUDY NULL');

  const [formData, setFormData] = useState({
    category: study.category,
    title: study.title,
    startDate: study.startDate,
    endDate: study.endDate,
    university: study.university,
    description: study.description,
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

  const handleSelectChange = (event, param) => {
    console.log(event.target.value);
    setFormData({
      ...formData,
      [param]: event.target.value,
    });
    //console.log(formData);
  };

  return (
    <Form className="loginCandidateForm center" onSubmit={handleAddEditSubmit}>
      <h2>Edit Study</h2>
      <Form.Group className="mb-3" controlId="formBasicPersonalData">
        <Form.Label>Study Level</Form.Label>
        <Form.Control
          aria-label="Default select example"
          onChange={(event) => handleSelectChange(event, 'category')}
          as="select"
          defaultValue={formData.category}
          name="category"
        >
          <option value="select" disabled>
            Select Study Level
          </option>
          <option value="nothing">No studies</option>
          <option value="highschool">High School</option>
          <option value="degree">Degree</option>
        </Form.Control>

        <Form.Label>Study Title</Form.Label>
        <Form.Control
          name="title"
          type="text"
          placeholder="Type your study title"
          value={formData.title}
          onChange={handleChange}
        />

        <Form.Label>Study Center</Form.Label>
        <Form.Control
          name="center"
          type="text"
          placeholder="Type your study center"
          value={formData.university}
          onChange={handleChange}
        />

        <Form.Label>Start Date</Form.Label>
        <Form.Control
          name="startDate"
          type="date"
          onChange={handleChange}
          value={formData.startDate}
        />

        <Form.Label>End Date</Form.Label>
        <Form.Control
          name="endDate"
          type="date"
          onChange={handleChange}
          value={formData.endDate}
        />

        <Form.Label>Description</Form.Label>
        <Form.Control
          as="textarea"
          name="description"
          placeholder="Type study description"
          style={{ height: '200px' }}
          value={formData.description}
          onChange={handleChange}
        />
      </Form.Group>

      <Button variant="primary" type="submit">
        Complete
      </Button>
    </Form>
  );
};

export default EditStudy;
