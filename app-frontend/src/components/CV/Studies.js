import React from 'react';
import Button from 'react-bootstrap/Button';

import { Link } from 'wouter';

import Study from './Study';

const Studies = ({ data }) => {
  return (
    <div className="cvPart column">
      <div className="cvPartHeader">
        <h5>Studies</h5>
        <Link to="/cv/add-study">
          <Button variant="outline-primary" className="companyButton">
            Add
          </Button>
        </Link>
      </div>
      <div className="experiences">
        {data.map((study) => (
          <Study key={study.id} data={study} />
        ))}
      </div>
    </div>
  );
};

export default Studies;
