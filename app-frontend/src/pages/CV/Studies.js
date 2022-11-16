import React from 'react';
import Button from 'react-bootstrap/Button';

import Study from './Study';

const Studies = () => {
  return (
    <div className="cvPart column">
      <div className="cvPartHeader">
        <h5>Studies</h5>
        <Button variant="outline-primary" className="companyButton">
          Add
        </Button>
      </div>
      <div className="experiences">
        <Study />
        <Study />
        <Study />
        <Study />
      </div>
    </div>
  );
};

export default Studies;
