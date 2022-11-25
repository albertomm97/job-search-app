import React, { useState } from 'react';

import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

import { useLocation } from 'wouter';
import { useUser } from '../../hooks/useUser';

import { getJobById } from '../../services/CompanyDetails/jobsOfferedService';

const EditOffer = ({ params }) => {
  const [, navigate] = useLocation();
  const { isLogged, type } = useUser();

  if (!isLogged || type !== 'company') navigate('/');

  const desiredOffer = getJobById({ id: params.id });

  console.log(desiredOffer);

  const [formData, setFormData] = useState({
    title: desiredOffer.title,
    category: desiredOffer.category,
    type: desiredOffer.type,
    place: desiredOffer.place,
    studies: desiredOffer.studies,
    experience: desiredOffer.experience,
    salary: desiredOffer.salary,
    description: desiredOffer.description,
  });

  const handleAddEditSubmit = (event) => {
    event.preventDefault();
    console.log(formData);
  };

  const handleChange = (event) => {
    const name = event.target.name;
    //console.log(`name: ${name} - value: ${event.target.value}`);
    setFormData({
      ...formData,
      [name]: event.target.value,
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
      <h2>Edit Offer</h2>
      <Form.Group className="mb-3" controlId="formBasicPersonalData">
        <Form.Group>
          <Form.Label>Offer Title</Form.Label>
          <Form.Control
            name="title"
            type="text"
            placeholder="Type offer title"
            value={formData.title}
            onChange={handleChange}
          />
        </Form.Group>
        <Form.Group>
          <Form.Label>Offer Category</Form.Label>
          <Form.Control
            aria-label="Default select example"
            onChange={(event) => handleSelectChange(event, 'category')}
            as="select"
            defaultValue={formData.category}
            name="category"
          >
            <option value="select" disabled>
              Select category
            </option>
            <option value="frontend">Frontend</option>
            <option value="backend">Backend</option>
            <option value="fullstack">Fullstack</option>
          </Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Offer Type</Form.Label>
          <Form.Control
            aria-label="Default select example"
            onChange={(event) => handleSelectChange(event, 'type')}
            as="select"
            defaultValue={formData.type}
            name="type"
          >
            <option value="select" disabled>
              Select type
            </option>
            <option value="remote">Full Remote</option>
            <option value="hybrid">Hybrid</option>
            <option value="office">Office</option>
          </Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Offer Place</Form.Label>
          <Form.Control
            aria-label="Default select example"
            onChange={(event) => handleSelectChange(event, 'place')}
            as="select"
            defaultValue={formData.place}
            name="place"
          >
            <option value="select" disabled>
              Select place
            </option>
            <option value="madrid">Madrid</option>
            <option value="valencia">Valencia</option>
            <option value="elche">Elche</option>
          </Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Offer studies requirements</Form.Label>
          <Form.Control
            aria-label="Default select example"
            onChange={(event) => handleSelectChange(event, 'studies')}
            as="select"
            defaultValue={formData.studies}
            name="studies"
          >
            <option value="select" disabled>
              Select minimun required studies
            </option>
            <option value="nothing">No studies</option>
            <option value="highschool">High School</option>
            <option value="degree">Degree</option>
          </Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Offer experience requirements</Form.Label>
          <Form.Control
            name="experience"
            type="number"
            placeholder="Experience in years"
            value={formData.experience}
            onChange={handleChange}
          />
        </Form.Group>
        <Form.Group>
          <Form.Label>Offer minimum salary</Form.Label>
          <Form.Control
            name="salary"
            type="number"
            placeholder="Salary"
            value={formData.salary}
            onChange={handleChange}
          />
        </Form.Group>
        <Form.Group>
          <Form.Label>Offer description</Form.Label>
          <Form.Control
            as="textarea"
            name="description"
            placeholder="Type job description"
            style={{ height: '200px' }}
            value={formData.description}
            onChange={handleChange}
          />
        </Form.Group>
      </Form.Group>

      <Button variant="primary" type="submit">
        Edit
      </Button>
    </Form>
  );
};

export default EditOffer;
