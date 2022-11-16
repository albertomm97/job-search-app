import React from 'react';
import Button from 'react-bootstrap/Button';

import WorkExperience from './WorkExperience';

const WorkExperiences = () => {
  return (
    <div className="cvPart column">
      <div className="cvPartHeader">
        <h5>Work experience</h5>
        <Button variant="outline-primary" className="companyButton">
          Add
        </Button>
      </div>
      <div className="experiences">
        <WorkExperience />
        <WorkExperience />
        <WorkExperience />
        <WorkExperience />
      </div>
    </div>
  );
};

export default WorkExperiences;
