import React from 'react';
import Button from 'react-bootstrap/Button';

import { Link } from 'wouter';

const Job = ({ data }) => {
  return (
    <div className="experience">
      <div className="experienceDetails">
        <h6>{data.title}</h6>
        <p>{data.companyName}</p>
        <p>
          {data.place} - {data.uploadDate}
        </p>
        <p>{data.description.slice(0, 100) + '...'}</p>
        <p>
          {data.type} - {data.experience} - {data.category} - {data.salary}
        </p>
      </div>
      <div className="experienceButtons">
        <Link to={`/company/job-offer/${data.id}`}>
          <Button variant="outline-success">View</Button>
        </Link>
      </div>
    </div>
  );
};

export default Job;
