import React, { useState } from 'react';

import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

import { useLocation } from 'wouter';
import { useUser } from '../../../hooks/useUser';

const EditLanguage = ({ params }) => {
  const [, navigate] = useLocation();
  const { isLogged, userData, type } = useUser();

  if (!isLogged || type !== 'user') navigate('/');

  const study = userData.languages.find((lang) => lang.id === params.id);

  const [formData, setFormData] = useState({
    language: study.language,
    level: study.level,
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
      <h2>Edit Language</h2>
      <Form.Group className="mb-3" controlId="formBasicPersonalData">
        <Form.Label>Language</Form.Label>
        <Form.Control
          aria-label="Default select example"
          onChange={(event) => handleSelectChange(event, 'language')}
          as="select"
          defaultValue={formData.language}
          name="language"
        >
          <option value="select" disabled>
            Select language
          </option>
          <option value="english">English</option>
          <option value="spanish">Spanish</option>
          <option value="german">German</option>
        </Form.Control>

        <Form.Label>Language Level</Form.Label>
        <Form.Control
          name="lvel"
          type="text"
          placeholder="Type your language level"
          onChange={handleChange}
          value={formData.level}
        />
      </Form.Group>

      <Button variant="primary" type="submit">
        Edit
      </Button>
    </Form>
  );
};

export default EditLanguage;
