import React, { useContext, useState } from 'react';

import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import FormGroup from 'react-bootstrap/esm/FormGroup';

import FilterOfferContext from '../../context/FilterOfferContext';

const FilterForm = () => {
  const [formData, setFormData] = useState({
    date: '',
    place: '',
    jobType: '',
    jobCategory: '',
    requiredStudies: '',
    requiredExperience: '',
    salary: '',
    workingHours: '',
  });

  const { filter, setFilter } = useContext(FilterOfferContext);

  const handleFilterSubmit = (event) => {
    event.preventDefault();
    const keyword = filter.keyword || '';
    setFilter({ keyword, ...formData });
  };

  const handleChange = (event) => {
    const name = event.target.name;
    setFormData({
      ...formData,
      [name]: formData[name] !== '' ? '' : event.target.value,
    });
  };

  return (
    <Form className="searchForm" onSubmit={handleFilterSubmit}>
      <FormGroup className="mb-3">
        <Form.Label>Upload date</Form.Label>
        <Form.Check
          name="date"
          value="anytime"
          label="Anytime"
          type="radio"
          onChange={handleChange}
        />
        <Form.Check
          name="date"
          value="last-24h"
          label="Last 24 hours"
          type="radio"
        />
        <Form.Check
          name="date"
          value="last-7d"
          label="Last 7 days"
          type="radio"
        />
      </FormGroup>
      <FormGroup className="mb-3">
        <Form.Label>Place</Form.Label>
        <Form.Check
          name="place"
          value="anytime"
          label="Anytime"
          onChange={handleChange}
        />
        <Form.Check name="place" value="last-24h" label="Last 24 hours" />
        <Form.Check name="place" value="last-7d" label="Last 7 days" />
      </FormGroup>

      <FormGroup className="mb-3">
        <Form.Label>Job Type</Form.Label>
        <Form.Check
          name="jobType"
          value="anytime"
          label="Anytime"
          onChange={handleChange}
        />
        <Form.Check name="jobType" value="last-24h" label="Last 24 hours" />
        <Form.Check name="jobType" value="last-7d" label="Last 7 days" />
      </FormGroup>

      <FormGroup className="mb-3">
        <Form.Label>Job Categories</Form.Label>
        <Form.Check
          name="jobCategory"
          value="anytime"
          label="Anytime"
          onChange={handleChange}
        />
        <Form.Check name="jobCategory" value="last-24h" label="Last 24 hours" />
        <Form.Check name="jobCategory" value="last-7d" label="Last 7 days" />
      </FormGroup>

      <FormGroup className="mb-3">
        <Form.Label>Required Studies</Form.Label>
        <Form.Check
          name="requiredStudies"
          value="anytime"
          label="Anytime"
          onChange={handleChange}
        />
        <Form.Check
          name="requiredStudies"
          value="last-24h"
          label="Last 24 hours"
        />
        <Form.Check
          name="requiredStudies"
          value="last-7d"
          label="Last 7 days"
        />
      </FormGroup>

      <FormGroup className="mb-3">
        <Form.Label>Required Experience</Form.Label>
        <Form.Check
          name="requiredExperience"
          value="0"
          label="No needed"
          onChange={handleChange}
        />
        <Form.Check
          name="requiredExperience"
          value="last-24h"
          label="Last 24 hours"
        />
        <Form.Check
          name="requiredExperience"
          value="last-7d"
          label="Last 7 days"
        />
      </FormGroup>

      <FormGroup className="mb-3">
        <Form.Label>Minimun Salary</Form.Label>
        <Form.Control
          name="salary"
          type="number"
          placeholder="Enter a number"
          onChange={handleChange}
        />
      </FormGroup>

      <FormGroup className="mb-3">
        <Form.Label>Working Hours</Form.Label>
        <Form.Check
          name="workingHours"
          value="0"
          label="No needed"
          onChange={handleChange}
        />
        <Form.Check
          name="workingHours"
          value="last-24h"
          label="Last 24 hours"
        />
        <Form.Check name="workingHours" value="last-7d" label="Last 7 days" />
      </FormGroup>

      <Button variant="primary" type="submit">
        Filter
      </Button>
    </Form>
  );
};

export default FilterForm;
