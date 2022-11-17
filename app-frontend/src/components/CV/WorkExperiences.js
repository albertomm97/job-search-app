import React, { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';

import WorkExperience from './WorkExperience';

import { Link } from 'wouter';
import { getWorkExperience } from '../../services/CV/getWorkExperience';

const WorkExperiences = () => {
  const [experience, setExperience] = useState([]);

  useEffect(() => {
    setExperience(getWorkExperience());
  }, []);

  return (
    <div className="cvPart column">
      <div className="cvPartHeader">
        <h5>Work experience</h5>
        <Link to="/cv/add-work-experience">
          <Button variant="outline-primary" className="companyButton">
            Add
          </Button>
        </Link>
      </div>
      <div className="experiences">
        {experience.map((exp) => (
          <WorkExperience key={exp.id} data={exp} />
        ))}
      </div>
    </div>
  );
};

export default WorkExperiences;
