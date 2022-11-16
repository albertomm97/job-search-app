import React from 'react';
import Button from 'react-bootstrap/Button';

const Language = () => {
  return (
    <div className="language">
      <div>
        <p>
          <span>Spanish</span>: <span>Native</span>
        </p>
      </div>
      <div className="experienceButtons">
        <Button variant="outline-success">Edit</Button>
        <Button variant="outline-danger">Delete</Button>
      </div>
    </div>
  );
};

export default Language;
