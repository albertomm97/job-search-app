import React from 'react';
import Button from 'react-bootstrap/Button';

import { Link } from 'wouter';

const Study = ({ data }) => {
  return (
    <div className="experience">
      <div className="experienceDetails">
        <h6>{data.title}</h6>
        <p>{data.university}</p>
        <p>{data.category}</p>
        <p>
          {data.startDate} - {data.endDate}
        </p>
        <p>{data.description}</p>
      </div>
      <div className="experienceButtons">
        <Link to={`/cv/edit-study/${data.id}`}>
          <Button variant="outline-success">Edit</Button>
        </Link>
        <Button variant="outline-danger">Delete</Button>
      </div>
    </div>
  );
};

export default Study;
