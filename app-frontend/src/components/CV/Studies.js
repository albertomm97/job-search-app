import React, { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';
import { getStudies } from '../../services/CV/getStudies';

import { Link } from 'wouter';

import Study from './Study';

const Studies = () => {
  const [studies, setStudies] = useState([]);

  useEffect(() => {
    setStudies(getStudies());
  }, []);

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
        {studies.map((study) => (
          <Study key={study.id} data={study} />
        ))}
      </div>
    </div>
  );
};

export default Studies;
