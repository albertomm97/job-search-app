import React, { useContext, useState } from 'react';

import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import FormGroup from 'react-bootstrap/esm/FormGroup';

import FilterOfferContext from '../../context/FilterOfferContext';

import { useFilterCategories } from '../../hooks/useFilterCategories';

const FilterForm = () => {
  const [formData, setFormData] = useState({
    date: '',
    place: [],
    jobType: [],
    jobCategory: [],
    requiredStudies: [],
    requiredExperience: '',
    salary: '',
    workingHours: [],
  });

  const { filter, setFilter } = useContext(FilterOfferContext);

  const categories = useFilterCategories();

  if (categories.length === 0) {
    return <></>;
  }

  const handleFilterSubmit = (event) => {
    event.preventDefault();
    const keyword = filter.keyword || '';
    setFilter({ keyword, ...formData });
  };

  const handleChange = (event) => {
    const name = event.target.name;
    const value = event.target.value;

    const element = formData[name];

    if (Array.isArray(element)) {
      let newVal = [];
      if (element.includes(value)) {
        newVal = element.filter((el) => el !== value);
      } else {
        newVal = [...element, value];
      }

      setFormData({
        ...formData,
        [name]: newVal,
      });
    } else {
      setFormData({
        ...formData,
        [name]: formData[name] !== '' ? '' : event.target.value,
      });
    }
  };

  const dates = categories.filter((category) => category.name === 'date');
  const places = categories.filter((category) => category.name === 'place');
  const jobTypes = categories.filter((category) => category.name === 'jobType');
  const jobCategories = categories.filter(
    (category) => category.name === 'jobCategory'
  );
  const studies = categories.filter(
    (category) => category.name === 'requiredStudies'
  );
  const experience = categories.find(
    (category) => category.name === 'requiredExperience'
  );
  const salary = categories.find((category) => category.name === 'salary');
  const workingHours = categories.filter(
    (category) => category.name === 'workingHours'
  );

  return (
    <Form className="searchForm" onSubmit={handleFilterSubmit}>
      <FormGroup className="mb-3">
        <Form.Label>Upload date</Form.Label>
        {dates.map((date) => {
          return (
            <Form.Check
              key={date.id}
              name={date.name}
              value={date.value}
              label={date.label}
              type="radio"
              onChange={handleChange}
            />
          );
        })}
      </FormGroup>
      <FormGroup className="mb-3">
        <Form.Label>Place</Form.Label>
        {places.map((place) => {
          return (
            <Form.Check
              key={place.id}
              name={place.name}
              value={place.value}
              label={place.label}
              onChange={handleChange}
            />
          );
        })}
      </FormGroup>

      <FormGroup className="mb-3">
        <Form.Label>Job Type</Form.Label>
        {jobTypes.map((jobType) => {
          return (
            <Form.Check
              key={jobType.id}
              name={jobType.name}
              value={jobType.value}
              label={jobType.label}
              onChange={handleChange}
            />
          );
        })}
      </FormGroup>

      <FormGroup className="mb-3">
        <Form.Label>Job Categories</Form.Label>
        {jobCategories.map((jobCategory) => {
          return (
            <Form.Check
              key={jobCategory.id}
              name={jobCategory.name}
              value={jobCategory.value}
              label={jobCategory.label}
              onChange={handleChange}
            />
          );
        })}
      </FormGroup>

      <FormGroup className="mb-3">
        <Form.Label>Required Studies</Form.Label>
        {studies.map((study) => {
          return (
            <Form.Check
              key={study.id}
              name={study.name}
              value={study.value}
              label={study.label}
              onChange={handleChange}
            />
          );
        })}
      </FormGroup>

      <FormGroup className="mb-3">
        <Form.Label>Required Experience</Form.Label>
        {
          <Form.Control
            name={experience.name}
            type="number"
            placeholder="Experience in years"
            onChange={handleChange}
          />
        }
      </FormGroup>

      <FormGroup className="mb-3">
        <Form.Label>Minimun Salary</Form.Label>
        {
          <Form.Control
            name={salary.name}
            type="number"
            placeholder="Enter a number"
            onChange={handleChange}
          />
        }
      </FormGroup>

      <FormGroup className="mb-3">
        <Form.Label>Working Hours</Form.Label>
        {workingHours.map((hours) => {
          return (
            <Form.Check
              key={hours.id}
              name={hours.name}
              value={hours.value}
              label={hours.label}
              onChange={handleChange}
            />
          );
        })}
      </FormGroup>

      <Button variant="primary" type="submit">
        Filter
      </Button>
    </Form>
  );
};

export default React.memo(FilterForm);
